package com.xebia.hr.dto;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.xebia.hr.entity.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserDto implements UserDetails{
	
	private String username;
	private String password;
	private String emailId;
	private String empName;
	private Date lastPasswordReset;
	private boolean isActive;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDto(Employee employee) {
		if(employee != null)
		{
			this.setUsername(employee.getEmpId());
			this.setPassword(employee.getPassword());
			this.setEmailId(employee.getEmail());
			this.setEmpName(employee.getName());
			this.setLastPasswordReset(employee.getLastPasswordReset());
			this.setActive(employee.isActive());
			this.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(employee.getAuthorities()));
		}		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.isActive;
	}

}
