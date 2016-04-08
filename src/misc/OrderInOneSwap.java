package misc;

//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

// Order given array in a maximum of one swap return true.

class OrderInOneSwap {
	public boolean solution(int[] A) {
		int[] copyA = Arrays.copyOf(A, A.length);
		Arrays.sort(copyA);

		int diffCnt = 0;
		for (int i = 0; i < A.length; i++) {
			Arrays.toString(A);
			
			if (A[i] != copyA[i])
				diffCnt++;
		}

		if (diffCnt > 2)
			return false;
		return true;
	}

	public static void main(String args[]) {

		// should print true

		int A[] = { 1, 5, 9, 8, 7, 22 };

		OrderInOneSwap orderInOneSwap = new OrderInOneSwap();
		boolean retn = orderInOneSwap.solution(A);

		System.out.println(retn);
	}
}