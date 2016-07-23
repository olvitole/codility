package crackingthecoding;

/**
 * Write a method to replace all spaces in a string with'%20'.
 * 
 * You may assume that the string has sufficient space at the end of the string
 * to hold the additional characters, and that you are given the "true" length
 * of the string.
 * 
 * (Note: if implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * 
 * EXAMPLE Input: "Mr John Smith Output: "Mr%20Dohn%20Smith"
 * 
 */

public class Q1Dot4 {

	private static final String REPLACE_STR = "%20";
	private static final char TO_REPLACE_CHAR = ' ';

	public static void main(String args[]) {

		try {

			String str = "A A A A";
			System.out.println("\n Test " + str);
			System.out.println(addPct20(str.toCharArray()));
			// replaceSpaces(str.toCharArray(), str.length());

			str = "   ";
			System.out.println("\n Test " + str);
			System.out.println(addPct20(str.toCharArray()));
			// replaceSpaces(str.toCharArray(), str.length());

			str = "";
			System.out.println("\n Test " + str);
			System.out.println(addPct20(str.toCharArray()));
			// replaceSpaces(str.toCharArray(), str.length());

			str = "AAA";
			System.out.println("\n Test " + str);
			System.out.println(addPct20(str.toCharArray()));
			// replaceSpaces(str.toCharArray(), str.length());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String addPct20(char[] strs) throws Exception {

		if (strs != null) {

			int size = strs.length;

			int whiteSpaces = countWhites(strs);

			int replaceStrCount = REPLACE_STR.length();
			int addedSpace = whiteSpaces * replaceStrCount;

			int newArraySize = size + addedSpace;

			char[] newStrs = new char[newArraySize];

			// main logic to replace spaces with replace str

			int j = 0;

			for (int i = 0; i < size; i++) {
				char temp = strs[i];
				if (temp != TO_REPLACE_CHAR) {
					newStrs[j] = strs[i];
					j++;
				} else {
					for (int k = 0; k < replaceStrCount; k++) {
						newStrs[j] = REPLACE_STR.charAt(k);
						j++;
					}
				}

			}

			return String.valueOf(newStrs);
		} else {
			throw new Exception("Error got null char array");
		}

	}

	private static int countWhites(char[] strs) {
		// count spaces
		int count = 0;
		for (int i = 0; i < strs.length; i++)
			if (strs[i] == TO_REPLACE_CHAR)
				count++;
		return count;
	}

	// solution in c will not run in java copide for documentation purposes

	public static void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, newLength, i;
		for (i = 0; i < length; i++) {

			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}

		System.out.println(str);
	}

}
