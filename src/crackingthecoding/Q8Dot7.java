package crackingthecoding;

import java.util.ArrayList;

/**
 * 8.7 Permutations without Dups: Write a method to compute all permutations of
 * a string of unique characters.
 * 
 */

public class Q8Dot7 {

	/**
	 * 
	 */

	public static void main(String args[]) {

		String str = "ABC";

		System.out.println(getPerms(str));

		System.out.println(getPermsII(str));
		
		System.out.println(getPermsIII(str));


	}

	// Approach 1: Building from permutations of first n-1 characters.

	private static ArrayList<String> getPerms(String str) {
		if (str == null)
			return null;

		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) {// base case
			permutations.add("");

			return permutations;
		}

		char first = str.charAt(0); // get the first char
		String remainder = str.substring(1); // remove the first char
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	private static/* Insert char c at index i in word. */
	String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;

	}

	// Approach 2: Building from permutations of all n-1 character substrings.

	private static ArrayList<String> getPermsII(String remainder) {
		int len = remainder.length();
		ArrayList<String> result = new ArrayList<String>();

		/* Base case. */
		if (len == 0) {
			result.add(""); // Be sure to return empty string!
			return result;
		}
		for (int i = 0; i < len; i++) {

			/* Remove char i and find permutations of remaining chars. */
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			ArrayList<String> partials = getPermsII(before + after);
			/* Prepend char i to each permutation. */
			for (String s : partials) {
				result.add(remainder.charAt(i) + s);
			}
		}
		return result;
	}

	// Approach 2 B

	static ArrayList<String> getPermsIII(String str) {
		ArrayList<String> result = new ArrayList<String>();
		getPermsIII("", str, result);
		return result;
	}

	static void getPermsIII(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0)
			result.add(prefix);

		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPermsIII(prefix + c, before + after, result);
		}
	}

}
