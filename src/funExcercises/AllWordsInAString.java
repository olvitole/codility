package funExcercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllWordsInAString {

	// find all words in a string

	public static void main(String args[]) {

		String str = "agaisrunngreencardstats.com";
		HashSet<String> dictionary = new HashSet<String>();
		
		dictionary.add("he");
		dictionary.add("is");
		dictionary.add("the");
		dictionary.add("green");
		//dictionary.add("a");
		dictionary.add("stats");
		dictionary.add("com");

		List<String> words = findWords(str, dictionary);

		System.out.println(words);
	}

	private static List findWords(String str, Set dictionary) {

		ArrayList<String> words = new ArrayList<String>();

		// index
		while (str.length() != 0) {
			String word = "";
			// merge
			for (int i = 0; i < str.length(); i++) {
				word = word + str.charAt(i);
				if (dictionary.contains(word))
					words.add(word);
			}
			str = str.substring(1);
		}
		return words;
	}
}
