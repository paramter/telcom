package com.lcs.tele.utils.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * sha加密
 * 
 * @author lcs
 */
public class ShaEncryption {
	public static final String ALGORITHM = "SHA-256";

	public static String SHA256Encrypt(String orignal) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if (null != md) {
			byte[] origBytes = orignal.getBytes();
			md.update(origBytes);
			byte[] digestRes = md.digest();
			String digestStr = getDigestStr(digestRes);
			return digestStr;
		}
		return null;
	}

	private static String getDigestStr(byte[] origBytes) {
		String tempStr = null;
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < origBytes.length; i++) {
			// 这里按位与是为了把字节转整时候取其正确的整数，Java中一个int是4个字节
			// 如果origBytes[i]最高位为1，则转为int时，int的前三个字节都被1填充了
			tempStr = Integer.toHexString(origBytes[i] & 0xff);
			if (tempStr.length() == 1) {
				stb.append("0");
			}
			stb.append(tempStr);
		}
		return stb.toString();
	}
	
	public static void main(String[] arg0){
		System.out.println(ShaEncryption.SHA256Encrypt("1"));
//		6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b
	}
}
