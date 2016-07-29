package geeksforgeeks.alphabet;

import java.util.Scanner;

/*
 
 You are in a party of N people, where only one person is known to everyone.
 Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. 
 Your task is to find the stranger (celebrity) in party.
 You will be given a square matrix M where if an element of row i and column j
   is set to 1 it means there is an edge from ith person to jth person. 
   An edge represent the relation that i th person knows j th person. 
   You need to complete the function getId which finds the id of the celebrity if present
    else return -1.
 The function getId takes two arguments the square matrix M and its size n.

Input:
The first line of input contains an element T denoting the No of test cases.
Then T test cases follow. Each test case consist of 2 lines.
The first line of each test case contains a number denoting the size of the matrix M. 
Then in the next line are space separated values of the matrix M.
 
Output:
For each test case output will be the id of the celebrity if present (0 based index). 
Else -1 will be printed. 

Constraints:
1<=T<=60
1<=N<=40
0<=M[][]<=1

Example:
Input (To be used only for expected output) 
1
3
0 1 0 0 0 0 0 1 0

Output 
1

Explanation 
For the above test case the matrix will look like
0 1 0 
0 0 0
0 1 0
Here  the celebrity is the person with index 1 ie id 1 


Note:The Input/Ouput format and Example given are used for system's internal purpose, 
and should be used by a user for Expected Output only. 
As it is a function problem, hence a user should not read any input from stdin/console. 
The task is to complete the function specified, and not to write the full code.

**For More Examples Use Expected Output**
 
 */

public class TheCelebrityProblem {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();

		for (int i = 0; i < testCases; i++) {
			System.out.println("case: " + testCases);

			int n = sc.nextInt();
			String rowData = sc.nextLine();
			int[][] data = parseIntoMatrix(rowData, n);

			printData(data);
		}

	}

	private static int[][] parseIntoMatrix(String rowData, int n) {

		int[][] data = new int[n][n];
		String[] dataSplit = rowData.split("\\ ");
		System.out.println("row data size: " + dataSplit.length + " rowData: " + rowData + " n: " + n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				data[i][j] = Integer.parseInt(dataSplit[i + j]);
			}
		}

		return data;
	}

	private static void printData(int[][] data) {

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

}
