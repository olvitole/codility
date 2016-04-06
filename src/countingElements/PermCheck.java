package countingElements;

class PermCheck {

	public int solution(int[] A) {
		boolean checked[] = new boolean[A.length];
		int count = A.length;

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= A.length) {
				if (!checked[A[i] - 1]) {
					checked[A[i] - 1] = true;
					count--;
				}

			}
		}

		if (count == 0)
			return 1;
		return 0;

	}

	public static void main(String args[]) {

		// should print 1

		int A[] = { 4, 1, 3, 2 };

		PermCheck sol = new PermCheck();
		int retn = sol.solution(A);

		System.out.println(retn);

		// should print 0

		int B[] = { 4, 1, 3 };

		retn = sol.solution(B);

		System.out.println(retn);
	}
}