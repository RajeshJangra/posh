package com.xebia.hr.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.xebia.hr.entity.Employee;

import lombok.Data;

@Data
public class UserDto implements UserDetails{
	
	private String username;
	private String password;
	private String emailId;
	private String empName;
	
	public UserDto(Employee employee) {
		if(employee != null)
		{
			this.setUsername(employee.getEmpId());
			this.setPassword(employee.getPassword());
			this.setEmailId(employee.getEmail());
			this.setEmpName(employee.getName());
		}		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
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
		return true;
	}

}
