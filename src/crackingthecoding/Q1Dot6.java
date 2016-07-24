package crackingthecoding;

import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 * 
 */

public class Q1Dot6 {

	public static void main(String args[]) {

		// note compress bad does not handle one of the conditions where
		// the compressed string should not be greater than the original

		// special cases
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("\n Test ");
		printMatrix(matrix);
		System.out.println("output");
		rotate(matrix);
		printMatrix(matrix);
		System.out.println("");
		rotate(matrix, matrix[0].length);
		printMatrix(matrix);

	}
	
	
	
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
	
	
	
	// book solution

	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				// save top
				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top;
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
