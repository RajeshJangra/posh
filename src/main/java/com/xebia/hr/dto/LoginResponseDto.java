package com.xebia.hr.dto;

import java.util.List;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class LoginResponseDto {

	private String username;
	private String token;
	private List<String> roles;
	
}
