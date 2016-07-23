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
		
		testString = "";
		System.out.println(testString);
		System.out.println(String.valueOf(reverse(testString.toCharArray())));

	}

	public static char[] reverse(char[] str) {

		int size = str.length;
		char[] newStr = new char[size];

		for (int i = 0; i < size; i++) {
			newStr[i] = str[size - 1 - i];
		}

		return newStr;
	}

}
