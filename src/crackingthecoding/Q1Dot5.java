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

		// note compress bad does not handle one of the conditions where
		// the compressed string should not be greater than the original

		// special cases
		String str = "ABBCCC";
		System.out.println("\n Test " + str);
		System.out.println("MY:     " + compress(str));
		System.out.println("BAD:    " + compressBad(str));
		System.out.println("BETTER: " + compressBetter(str));
		System.out.println("ALT BE: " + compressAlternate(str));


		str = "";
		System.out.println("\n Test " + str);
		System.out.println("MY:     " + compress(str));
		// compress bad fails on this "" case
		// System.out.println("BAD:    " + compressBad(str));
		System.out.println("BETTER: " + compressBetter(str));
		System.out.println("ALT BE: " + compressAlternate(str));


		str = "A";
		System.out.println("\n Test " + str);
		System.out.println("MY:     " + compress(str));
		System.out.println("BAD:    " + compressBad(str));
		System.out.println("BETTER: " + compressBetter(str));
		System.out.println("ALT BE: " + compressAlternate(str));


		str = "AA";
		System.out.println("\n Test " + str);
		System.out.println("MY:     " + compress(str));
		System.out.println("BAD:    " + compressBad(str));
		System.out.println("BETTER: " + compressBetter(str));
		System.out.println("ALT BE: " + compressAlternate(str));


		str = "ABABABABABAB";
		System.out.println("\n Test " + str);
		System.out.println("MY:     " + compress(str));
		System.out.println("BAD:    " + compressBad(str));
		System.out.println("BETTER: " + compressBetter(str));
		System.out.println("ALT BE: " + compressAlternate(str));


		// regular cases
		str = "AAAAAAA";
		System.out.println("\n Test " + str);
		System.out.println("MY:     " + compress(str));
		System.out.println("BAD:    " + compressBad(str));
		System.out.println("BETTER: " + compressBetter(str));
		System.out.println("ALT BE: " + compressAlternate(str));


		str = "ABBCCCDDDDCCCBBA";
		System.out.println("\n Test " + str);
		System.out.println("MY:     " + compress(str));
		System.out.println("BAD:    " + compressBad(str));
		System.out.println("BETTER: " + compressBetter(str));
		System.out.println("ALT BE: " + compressAlternate(str));


		str = "ABBCCCDDDDEEEEEDDDDCCCBBA";
		System.out.println("\n Test " + str);
		System.out.println("MY:     " + compress(str));
		System.out.println("BAD:    " + compressBad(str));
		System.out.println("BETTER: " + compressBetter(str));
		System.out.println("ALT BE: " + compressAlternate(str));


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

	/// SOLUTIONSSSSSSSSS FROM BOOK

	/// bad

	public static String compressBad(String str) {
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) { // Found repeat char
				count++;
			} else { // Insert char count, and update last char
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;

	}
	/// good

	public static String compressBetter(String str) {

		/* Check if compression would create a longer string */
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) { //
				count++;
			} else { // Insert char count,
				// Found repeated char
				// and update last char
				mystr.append(last); // Insert char
				mystr.append(count); // Insert count
				last = str.charAt(i);
				count = 1;
			}
		}
		/*
		 * In lines 15 - 16 above, characters are inserted when the repeated
		 * character changes. We the end of the method as well, need to update
		 * the string at since the very last set of repeated characters wouldn't
		 * be set in the compressed string yet.
		 */
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}

	private static int countCompression(String str) {
		if (str == null || str.isEmpty())
			return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {

			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;

	}
	
	/// better alternative no stringbuffer solution

	public static String compressAlternate(String str) {
		/* Check if compression would create a longer string */
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}

		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) { // Found repeated character
				count++;
			} else {
				/* Update the repeated character count */
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}

		/* Update string with the last set of repeated characters. */
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}

	private static int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;

		/* Convert the count to a string, then to an array of chars */
		char[] cnt = String.valueOf(count).toCharArray();

		/* Copy characters from biggest digit to smallest */
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}

}
