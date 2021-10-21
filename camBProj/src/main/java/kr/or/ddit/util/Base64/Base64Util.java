package kr.or.ddit.util.Base64;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
	
	public static void main(String args[]) {
		
		String orginText = "1234";
		System.out.println("orginText : " + orginText);
		
		Map<String, Object> map = base64Encoding(orginText);
		String encodedText =  (String) map.get("text");
		byte[] encodedBytes = (byte[]) map.get("encodedBytes");
		System.out.println("encodedText : " + encodedText);
		System.out.println("encodedBytes : " + encodedBytes);
		
		String decodedText = base64Decoding(encodedText, encodedBytes); 
		System.out.println("decodedText : " + decodedText);
	} 
	
	public static Map<String, Object> base64Encoding(String text) { 
		/* base64 encoding */ 
		byte[] key = Base64.encodeBase64(text.getBytes());
		
		Map<String, Object> map = new HashMap<String, Object>();
		text =  new String(key);
		
		map.put("text", text);
		map.put("key", key);
		
		return map;
	}
	
	public static String base64Decoding(String encodedText, byte[] key) { 
		/* base64 decoding */ 
		byte[] decodedBytes = Base64.decodeBase64(key); 
		String decodedText =  new String(decodedBytes);
		return decodedText;
	}
}
