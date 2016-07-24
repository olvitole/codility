package crackingthecoding;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check If s2 is a
 * rotation of s1 using only onecalltoisSubstring (e.g., "waterbottLe" is a
 * rotation of "erbottLewat").
 * 
 */

public class Q1Dot8 {

	public static void main(String args[]) {

		// special cases
		String s1 = "olvi";
		String s2 = "viol";
		System.out.println("\n Test ");
		System.out.println("s1: " + s1 + " s2: " + s2);
		System.out.println(isRotation(s1, s2));

		s1 = "olvi";
		s2 = "ivol";
		System.out.println("\n Test ");
		System.out.println("s1: " + s1 + " s2: " + s2);
		System.out.println(isRotation(s1, s2));

	}

	// check if s2 is rotation of s1 with one call to isSubstring;
	public static boolean isRotation(String s1, String s2) {
		if (s1 == null && s2 == null)
			return true;
		if (s1 == null || s2 == null)
			return false; // note if both, was handled above
		
		if (s1.length() != s2.length())
			return false;
		return isSubstring(s1, s2 + s2);

	}

	public static boolean isSubstring(String substring, String string) {
		return string.contains(substring);
	}

}
