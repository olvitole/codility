package crackingthecoding;

import java.util.HashMap;

/*
 Given two strings, write a method to decide if one is a permutation of the other.
 
 */

public class Q1Dot3 {

	public static void main(String args[]) {

		String testString = "123A";
		String testString2 = "132A";
		System.out.println("\n Test " + testString + "  " + testString2);
		System.out.println(isPermutation(testString, testString2));

		
		testString = "";
		testString2 = "";
		System.out.println("\n Test " + testString + "  " + testString2);
		System.out.println(isPermutation(testString, testString2));
		
		testString = "12";
		testString2 = "123";
		System.out.println("\n Test " + testString + "  " + testString2);
		System.out.println(isPermutation(testString, testString2));
		
		testString = "1";
		testString2 = "1111";
		System.out.println("\n Test " + testString + "  " + testString2);
		System.out.println(isPermutation(testString, testString2));
		
		testString = "1122";
		testString2 = "1111";
		System.out.println("\n Test " + testString + "  " + testString2);
		System.out.println(isPermutation(testString, testString2));
		
	}

	public static boolean isPermutation(String str, String str2) {

		// key count
		HashMap<Character, Integer> mapInventoryStr = countInventory(str);
		HashMap<Character, Integer> mapInventoryStr2 = countInventory(str2);

		boolean matchOneWay = checkMatch(mapInventoryStr, mapInventoryStr2);
		boolean matchTwoWay = checkMatch(mapInventoryStr2, mapInventoryStr);

		return matchOneWay && matchTwoWay;
	}

	// add all
	private static HashMap<Character, Integer> countInventory(String str) {
		HashMap<Character, Integer> mapInventory = new HashMap<Character, Integer>();

		for (Character c : str.toCharArray()) {
			addToMap(mapInventory, c);
		}

		return mapInventory;

	}

	// add one at a time
	private static void addToMap(HashMap<Character, Integer> mapInventory, Character c) {
		if (mapInventory.containsKey(c)) {
			int val = mapInventory.get(c);
			val++;
			mapInventory.put(c, val);
		} else {

			mapInventory.put(c, 1);
		}

	}

	// check if values match
	private static boolean checkMatch(HashMap<Character, Integer> mapInventory,
			HashMap<Character, Integer> mapInventory2) {
		
		for(Character c : mapInventory.keySet()){
			if (mapInventory2.containsKey(c)){
				int val1 = mapInventory.get(c);
				int val2 = mapInventory2.get(c);
				if (val1!=val2){
					return false;
				}
			}else
				return false;
		}
		
		return true;

	}

}
