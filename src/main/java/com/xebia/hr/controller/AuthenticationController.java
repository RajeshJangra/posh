package com.xebia.hr.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.hr.constants.AppConstants;
import com.xebia.hr.dto.LoginRequestDto;
import com.xebia.hr.dto.LoginResponseDto;
import com.xebia.hr.dto.UserDto;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.security.TokenUtils;
import com.xebia.hr.service.EmployeeService;
import com.xebia.hr.service.InductionUserDetailsService;

@RestController
@RequestMapping(value="/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private InductionUserDetailsService inductionUserDetailsService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> authenticationRequest(@RequestBody @Valid LoginRequestDto loginRequestDto) throws AuthenticationException {

		// Perform the authentication
		Authentication authentication = this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequestDto.getUsername(),
						loginRequestDto.getPassword()
						)
				);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-authentication so we can generate token
		UserDetails userDetails = this.inductionUserDetailsService.loadUserByUsername(loginRequestDto.getUsername());
		String token = this.tokenUtils.generateToken(userDetails);

		// Return the token
		return ResponseEntity.ok(new LoginResponseDto(loginRequestDto.getUsername(), token, getRoles(userDetails.getAuthorities()) ));
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
		String token = request.getHeader(AppConstants.X_AUTH_TOKEN);
		String username = this.tokenUtils.getUsernameFromToken(token);
		UserDto user = (UserDto) this.inductionUserDetailsService.loadUserByUsername(username);
		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
			String refreshedToken = this.tokenUtils.refreshToken(token);
			return ResponseEntity.ok(new LoginResponseDto(username, refreshedToken, getRoles(user.getAuthorities()) ));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@RequestMapping(value="/invalidate", method = RequestMethod.GET)
	public void invalidateToken(@RequestHeader(AppConstants.X_AUTH_TOKEN) String authToken) throws AuthenticationException {
		SecurityContextHolder.getContext().setAuthentication(null);
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(@RequestBody UserDto user) 
			throws IOException {
		try {
			Employee employee = employeeService.findByEmpId(user.getUsername());
			employee.setPassword(user.getPassword());
			employee.setLastPasswordReset( new Date(System.currentTimeMillis()) );
			employeeService.createEmployee(employee);
			return ResponseEntity.ok("Password changes successfully.");
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private List<String> getRoles(Collection<? extends GrantedAuthority> authorities){
		return authorities.stream().map(authority -> authority.getAuthority()).collect(Collectors.toList());
	}

}
