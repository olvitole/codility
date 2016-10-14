package crackingthecoding;

import java.util.Arrays;

/**
 * 
 * 8.1
 * 
 * Triple Step: A child is running up a staircase with n steps and can hop
 * either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how
 * many possible ways the child can run up the stairs.
 *
 * @author olvitole
 */

public class Q8Dot1 {

	/**
	 * analysis
	 * 
	 * 1 stair 1 step 1 way 2 stair 2x1step or 1x2step = 2ways 3 stair 3x1step
	 * or 1x2step + 1x2step or or 1x3step = 4ways 4 stair 4x1step or 2x2step or
	 * 1x2step + 2x1step or ....
	 */

	public static void main(String args[]) {

		int nStairs = 13;

		int ways = findWays(nStairs);

		System.out.println("Ways: " + ways);

		System.out.print("Count Ways " + countWays(nStairs));

	}

	private static int findWays(int n) {

		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else
			return findWays(n - 1) + findWays(n - 2) + findWays(n - 3);

	}

	static int countWays(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}

	static int countWays(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo)
					+ countWays(n - 3, memo);
			return memo[n];
		}
	}
}
