package com.xebia.hr.dto;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gauravagrawal
 *
 */
@Data
@NoArgsConstructor
@ToString
public class LoginRequestDto {

	@NotBlank(message= "username must not be blank")
	private String username;
	
	@NotBlank(message= "password must not be blank")
	private String password;
	
}
