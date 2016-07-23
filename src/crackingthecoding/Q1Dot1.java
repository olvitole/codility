package crackingthecoding;

public class Q1Dot1 {

	public static void main(String args[]) {

		String testString = "123A";
		System.out.println(testString);
		System.out.println(hasUniqueCharacters(testString));
		System.out.println(isUniqueChars2(testString));
		System.out.println(isUniqueChars(testString));

		testString = "123AA";
		System.out.println(testString);
		System.out.println(hasUniqueCharacters(testString));
		System.out.println(isUniqueChars2(testString));
		System.out.println(isUniqueChars(testString));


	}

	public static boolean hasUniqueCharacters(String testString) {

		StringBuffer validated = new StringBuffer();

		for (int i = 0; i < testString.length(); i++) {

			String tempC = "" + testString.charAt(i);

			if (validated.toString().contains(tempC))
				return false;

			validated.append(tempC);

		}

		return true;

	}

	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256)
			return false;

		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) { // Already found this char in string
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static boolean isUniqueChars(String str) {

		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

}
