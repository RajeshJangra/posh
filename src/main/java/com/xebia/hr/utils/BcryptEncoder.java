package com.xebia.hr.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BcryptEncoder {

	public static String getEncodedString(String value){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(value);
	}
	
	public static void main(String[] args) {
		System.out.println(BcryptEncoder.getEncodedString("ww"));
	}
	
}
