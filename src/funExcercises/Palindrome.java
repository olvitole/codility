package funExcercises;

public class Palindrome {

	public static void main(String[] args) {

		String word = "";

		// test cases
		// true

		word = "aba";
		System.out.println(isPalindrome(word));
		
		// false
		word = "abab";
		System.out.println(isPalindrome(word));

	}

	public static boolean isPalindrome(String word) {

		int len = word.length();

		if (len == 0 || len == 1) {
			return true;
		} else if (word.charAt(0) != word.charAt(len - 1)) {
			return false;
		}

		return isPalindrome(word.substring(1, len - 1));

	}

}
