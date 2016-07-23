package crackingthecoding;

/*
 Implement a function void reverse(char* str) in C or C++ which reverses a nullterminated
string.
 */

public class Q1Dot2 {

	public static void main(String args[]) {

		String testString = "123A";
		System.out.println(testString);
		System.out.println(String.valueOf(reverse(testString.toCharArray())));
		System.out.println(reverse(testString));

		testString = "";
		System.out.println(testString);
		System.out.println(String.valueOf(reverse(testString.toCharArray())));

	}

	// with new array
	public static char[] reverse(char[] str) {

		int size = str.length;
		char[] newStr = new char[size];

		for (int i = 0; i < size; i++) {
			newStr[i] = str[size - 1 - i];
		}

		return newStr;
	}

	// recursion
	public static String reverse(String str) {
		int length = str.length();
		if (length <= 0)
			return "";
		else {
			return str.substring(length - 1, length) + reverse(str.substring(0, length - 1));
		}
	}

}
