package amazon;

import java.util.ArrayList;
import java.util.HashSet;

public class AmazonBeanStalk2 {

	public static void main(String args[]) {

		String testStr = "suspercalifragilisticexpialidocious";
		Character rtn = findFirst(testStr);
		System.out.println(rtn);
	}

	/*
	 * Question 2
	 * 
	 * Given a string of characters, find the first character that occurs only
	 * once. e.g. suspercalifragilisticexpialidocious --> f
	 * 
	 */

	public static Character findFirst(String sequence) {
		HashSet<Character> showed = new HashSet<Character>();
		ArrayList<Character> showOnce = new ArrayList<Character>();

		for (int i = 0; i < sequence.length(); i++) {
			Character tempC = sequence.charAt(i);

			if (showed.contains(tempC)) {
				showOnce.remove(tempC);
				// showed.add(tempC);
			} else {
				showOnce.add(tempC);
				showed.add(tempC);
			}

		}

		if (showOnce.size() <= 0)
			return null;
		return showOnce.get(0);

	}
}
