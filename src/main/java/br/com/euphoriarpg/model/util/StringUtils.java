package br.com.euphoriarpg.model.util;

public class StringUtils {
	
	public static boolean isNullorEmpty(String string) {
			
		if(string.isEmpty() || string == null) {
			return false;
		}
		
		return true;
	}

}
