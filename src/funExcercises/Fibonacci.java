package funExcercises;

public class Fibonacci {

	public static void main(String[] args) {

		int n = 5;

		for (int i = 0; i < n; i++) {

			System.out.println(fibonacci(i));
		}
	}

	public static int fibonacci(int n) {
		if (n <= 1)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);

	}

}
