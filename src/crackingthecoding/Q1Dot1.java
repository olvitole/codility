package crackingthecoding;

public class Q1Dot1 {

	public static void main(String args[]) {

		String testString = "123A";
		System.out.println(testString);
		System.out.println(hasUniqueCharacters(testString));

		testString = "123AA";
		System.out.println(testString);
		System.out.println(hasUniqueCharacters(testString));

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

}
