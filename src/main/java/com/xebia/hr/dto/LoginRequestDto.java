package com.xebia.hr.dto;

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

	private String username;
	private String password;
	
}
