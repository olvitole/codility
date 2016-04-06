package prefixSums;

public class PassingCars {

	public int solution(int[] A) {

		int west = 0;
		int passing = 0;

		for (int i = A.length-1; i >= 0 ; i--) {
			if (A[i] == 0) {
				passing += west;
				if (passing > 1000000000)
					return -1;
			} else {
				west++;
			}
		}
		return passing;
	}

	public static void main(String args[]) {

		// should print 5

		int A[] = { 0, 1, 0, 1, 1 };

		PassingCars fjmp = new PassingCars();
		int retn = fjmp.solution(A);

		System.out.println(retn);
	}
}
