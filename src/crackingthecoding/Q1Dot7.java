package crackingthecoding;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 * 
 */

public class Q1Dot7 {

	private static final int REPLACE_VALUE = 0;

	public static void main(String args[]) {

		// note compress bad does not handle one of the conditions where
		// the compressed string should not be greater than the original

		// special cases
		int matrix[][] = { { 1, 2, 3, 4 }, { 4, 5, 0, 7 }, { 7, 8, 9, 1 } };
		System.out.println("\n Test ");
		printMatrix(matrix);
		System.out.println("output Me");
		int[][] cpy = zero(matrix);
		printMatrix(cpy);
		
		
		int matrix2[][] = { { 1, 2, 3, 4 }, { 4, 5, 0, 7 }, { 7, 8, 9, 1 } };
		System.out.println("\n Test ");
		printMatrix(matrix2);
		System.out.println("output");
		setZeros(matrix2);
		printMatrix(matrix2);


	}

	public static int[][] zero(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		System.out.println("m: " + m + " n: " + n);

		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();

		// go over rows

		for (int i = 0; i < m; i++) {
			// find 0 with binary
			for (int k = 0; k < n; k++) {
				if (matrix[i][k] == REPLACE_VALUE) {
					rows.add(i);
					cols.add(k);
				}
			}
		}

		for (int r : rows) {
			for (int i = 0; i < n; i++) {
				matrix[r][i] = REPLACE_VALUE;
			}

		}

		for (int c : cols) {
			for (int i = 0; i < m; i++) {
				matrix[i][c] = REPLACE_VALUE;
			}

		}

		return matrix;
	}

	// book solution

	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private static void printMatrix(int[][] grid) {

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++)
				System.out.print(grid[r][c] + " ");
			System.out.println();
		}
	}
}
