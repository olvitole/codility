package timeComplexity;

class TapeEquillibrium {

	public int solution(int[] A) {
		int n = A.length;

		int left = A[0];
		int right = sumA(A) - left;
		int min = Math.abs(right - left);
		for (int i = 1; i < n - 1; i++) {
			left += A[i];
			right -= A[i];
			if (min >= Math.abs(right - left)) {
				min = Math.abs(right - left);
			}
		}

		return min;
	}

	private int sumA(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
		}
		return sum;
	}

	public static void main(String args[]) {

		// should print 1

		int A[] = { 3, 1, 2, 4, 3 };

		TapeEquillibrium sol = new TapeEquillibrium();
		int retn = sol.solution(A);

		System.out.println(retn);
	}
}