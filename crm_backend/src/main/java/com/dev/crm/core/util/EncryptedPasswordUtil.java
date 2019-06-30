package com.dev.crm.core.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtil {

	public static void main(String[] args) {
		 
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = "15726867";
		System.out.println(bCryptPasswordEncoder.encode(password));
	}
}
