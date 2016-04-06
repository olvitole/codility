package timeComplexity;

class Frogjmp {
	public int solution(int X, int Y, int D) {

		int distances = Y - X;

		int jumps = distances / D;

		if (distances % D == 0)
			return jumps;
		else
			return jumps + 1;

	}

	public static void main(String args[]) {

		// should print 3

		int x = 10;
		int y = 85;
		int d = 30;

		Frogjmp fjmp = new Frogjmp();
		int retn = fjmp.solution(x, y, d);

		System.out.println(retn);
	}
}