package app4Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.management.RuntimeErrorException;

import org.apache.tomcat.util.codec.binary.Base64;

import sun.misc.BASE64Encoder;

public class MD5Utils {
	public static String encoding(String message){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte b[] = md.digest(message.getBytes());
			return new BASE64Encoder().encode(b);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
