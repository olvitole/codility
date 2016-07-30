package funExcercises;

public class Permutations {

	private static boolean used[];

	private static StringBuilder out = new StringBuilder();

	private static String in = "";

	public static void main(String[] args) {

		String test = "asdf";

		in = test;
		used = new boolean[in.length()];

		permutate();

	}

	public static void permutate() {

		if (out.length() == in.length()) {
			System.out.println(out);
			return;
		} else {
			for (int i = 0; i < in.length(); i++) {
				if (used[i])
					continue;
				out.append(in.charAt(i));
				used[i] = true;
				permutate();
				used[i] = false;
				out.setLength(out.length() - 1);
			}
		}
	}

}
