package com.xebia.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xebia.hr.dto.UserDto;
import com.xebia.hr.entity.Employee;

@Service
public class InductionUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeService employeeService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee employee = employeeService.findByEmpId(username);
		if(employee == null){
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
		return new UserDto(employee);
	}

}
