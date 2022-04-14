package com.bia.web.utils;

public class NumberTools {
	
	public static int parseIntWithFallback(String numStr) {
		return parseIntWithFallback(numStr, 0);
	}
	
	public static int parseIntWithFallback(String numStr, Integer fallback) {
		
		if (numStr != null) {
			try {
				return Integer.parseInt(numStr);
			} catch (Exception ignored) {}			
		}
		
		if (fallback != null) {
			return fallback;
		}
		return 0;
	}
}
