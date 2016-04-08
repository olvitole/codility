package misc;

//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

// find largest subset of array such as subset is { A[K], A[A[K]], A[A[A[K]]] }
// important no repeats

class SubSetOfArray {
	
	public int solution(int[] A) {

		if (A == null || A.length == 0)
			return 0;

		int n = A.length;

		int max = 0;

		for (int i = 0; i < n; i++) {
			int K = i;
			int szFnd = findSize(K, A);
			if (szFnd > max)
				max = szFnd;

		}
		return max;
	}

	private int findSize(int K, int[] A) {
		int rtnr = K;
		ArrayList<Integer> fnd = new ArrayList<Integer>();
		while (rtnr < A.length) {
			rtnr = A[rtnr];
			if (!fnd.contains(rtnr))
				fnd.add(rtnr);
			else
				break;
		}
		return fnd.size();
	}

	public static void main(String args[]) {

		// should print 4

		int A[] = { 5, 4, 0, 3, 1, 6, 2 };

		SubSetOfArray subSetOfArray = new SubSetOfArray();
		int retn = subSetOfArray.solution(A);

		System.out.println(retn);
	}

}
