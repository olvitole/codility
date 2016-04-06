package timeComplexity;

class PermMissingElem {

	public int solution(int[] A) {
		int n = A.length;

		int overallSum = 0;
		int missingSum = 0;
		for (int i = 0; i < n; i++) {
			overallSum = overallSum + i;
			missingSum = missingSum + A[i];
		}
		overallSum = overallSum + 2 * n + 1;
		return overallSum - missingSum;
	}

	public static void main(String args[]) {

		// should print 4

		int A[] = { 2, 3, 1, 5 };

		PermMissingElem sol = new PermMissingElem();
		int retn = sol.solution(A);

		System.out.println(retn);
	}
}