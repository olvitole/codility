package crackingthecoding;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters.
 * 
 * For example, the string aabcccccaaa would become a2blc5a3.
 * 
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string.
 * 
 */

public class Q1Dot5 {

	public static void main(String args[]) {

		// special cases
		String str = "ABBCCC";
		System.out.println("\n Test " + str);
		System.out.println(compress(str));

		str = "";
		System.out.println("\n Test " + str);
		System.out.println(compress(str));
		
		str = "A";
		System.out.println("\n Test " + str);
		System.out.println(compress(str));

		str = "AA";
		System.out.println("\n Test " + str);
		System.out.println(compress(str));
		
		str = "ABABABABABAB";
		System.out.println("\n Test " + str);
		System.out.println(compress(str));
		
		
		// regular cases
		str = "AAAAAAA";
		System.out.println("\n Test " + str);
		System.out.println(compress(str));
		
		str = "ABBCCCDDDDCCCBBA";
		System.out.println("\n Test " + str);
		System.out.println(compress(str));
		
		str = "ABBCCCDDDDEEEEEDDDDCCCBBA";
		System.out.println("\n Test " + str);
		System.out.println(compress(str));
		
	}

	private static String compress(String str) {

		if (str == null || str.length() <= 2)
			return str;

		char cMin = str.charAt(0);
		char cMax;
		int cnt = 1;
		String newStr = "" + cMin;
		for (int i = 1; i < str.length(); i++) {
			cMax = str.charAt(i);
			// base case
			if (cMin == cMax) {
				cnt++;
			} else {
				newStr += cnt;
				cMin = cMax;
				cnt = 1;
				newStr += cMin;
			}
		}

		newStr += cnt;
		if (newStr.length() >= str.length())
			return str;
		else
			return newStr;
	}

}
