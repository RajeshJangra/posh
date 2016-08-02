package com.xebia.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xebia.hr.dto.UserDto;
import com.xebia.hr.entity.Employee;
import com.xebia.hr.exceptions.NotFoundException;

@Service
public class InductionUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeService employeeService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee employee = null;
		try {
			employee = employeeService.findByEmpId(username);
		} catch (NotFoundException e) {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return new UserDto(employee);
	}

}
