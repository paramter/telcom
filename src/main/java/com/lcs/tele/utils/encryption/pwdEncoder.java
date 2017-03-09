package com.lcs.tele.utils.encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class pwdEncoder {
	@Autowired
	public static String passwordEncoder(String password){
		PasswordEncoder passwordEncoder = new PasswordEncoder() {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				return false;
			}
			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return passwordEncoder.encode(password);
	}
	
	public static void main(String[] arg0){
		
		System.out.println(passwordEncoder("1"));
	}
}
