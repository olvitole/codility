package prefixSums;

public class CountDiv {

    public int solution(int A, int B, int K) {
    	
    	int high = B/K;
    	int low = A/K;
    	if (A%K==0)
    		high++;
    	
        return high-low;
    }

	public static void main(String args[]) {

		// should print 3

		int A = 6;
		int B = 11;
		int K =2;
		CountDiv sol = new CountDiv();
		int retn = sol.solution(A, B, K);
		System.out.println(retn);
		
		// should print 0

		A = 1;
		B = 1;
		K =11;
		retn = sol.solution(A, B, K);
		System.out.println(retn);
	}
}
