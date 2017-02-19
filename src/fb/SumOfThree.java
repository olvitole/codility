package fb;

import java.util.Arrays;

// check if the sum of three elements of an array is equal to n
public class SumOfThree {

	// sum of three numbers from the array adds up to sum

	private static boolean hasSum(int arr[], int sum) {

		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length - 2; i++) {
			int l = i + 1;
			int r = arr.length - 1;

			while (l < r) {
				int ts = arr[l] + arr[i] + arr[r];
				if (ts == sum) {
					System.out.println("Found: " + arr[l] + " " + arr[i] + " " + arr[r]);
					return true;
				} else if (ts < sum) {
					l++;
				} else {
					r--;
				}

			}
		}
		return false;
	}

	// Driver prorgram
	public static void main(String args[]) {
		int arr[] = { 3, 1, 2, 4, 2, 9 };
		int n = 9;
		boolean sm = hasSum(arr, n);
		System.out.println(sm);
	}

}
