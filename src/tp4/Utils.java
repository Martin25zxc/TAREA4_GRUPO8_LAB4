package tp4;

import java.util.regex.Pattern;

public class Utils {
	public static boolean isNullOrEmpty(String s) {
	    return s == null || s == "" || s.length() == 0;
	}

	public static boolean isNullOrWhitespace(String s) {
	    return s == null || isWhitespace(s);

	}
	private static boolean isWhitespace(String s) {
	    int length = s.length();
	    if (length > 0) {
	        for (int i = 0; i < length; i++) {
	            if (!Character.isWhitespace(s.charAt(i))) {
	                return false;
	            }
	        }
	        return true;
	    }
	    return false;
	}
}
