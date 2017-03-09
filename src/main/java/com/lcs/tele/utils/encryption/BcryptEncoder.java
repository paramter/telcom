package com.lcs.tele.utils.encryption;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * bcrypt加密
 * @author lcs
 */
public class BcryptEncoder {
	/**
	 * 对密码进行bcrypt加密
	 * @param password
	 * @return 加密后字符串
	 */
	public static String passwordEncoder(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt()); 
	}
	
	public static void main(String[] arg0){
		String password = "admin";  
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
        System.out.println(passwordEncoder.encode(password));
	}
}
