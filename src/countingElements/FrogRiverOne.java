package countingElements;

class FrogRiverOne {

	public int solution(int X, int[] A) {

		boolean[] checked = new boolean[X];
		int validated = X;

		for (int i = 0; i < A.length; i++) {

			if (A[i] <= X) {
				if (!checked[A[i] - 1]) {
					checked[A[i] - 1] = true;
					validated--;
				}
			}

			if (validated==0) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String args[]) {

		// should print 4

		int X = 5;
		int A[] = { 1, 3, 1, 4, 2, 3, 5, 4 };

		FrogRiverOne sol = new FrogRiverOne();
		int retn = sol.solution(X, A);

		System.out.println(retn);
	}
}