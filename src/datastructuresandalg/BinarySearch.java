package datastructuresandalg;

public class BinarySearch {

	public static void main(String args[]) {

		// ind find
		int target = 12343;

		int[] bucket = { 2, 4, 5, 23, 25, 99, 123, 323, 454, 1212, 12343 };

		int index = binarySearch(bucket, target);

		System.out.println(index);

	}

	public static int binarySearch(int[] bucket, int target) {

		int lower = 0;
		int upper = bucket.length-1;

		try {
			return binarySearch(bucket, target, lower, upper);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return -1;
	}

	private static int binarySearch(int[] bucket, int target, int lower, int upper) throws Exception {

		int center, range;

		range = upper - lower;

		if (range < 0)
			throw new Exception("Upper lower are reversed");
		else if (range == 0 && bucket[lower] != target)
			throw new Exception("The element is not on the bucket");

		if (bucket[lower] > bucket[upper]) {
			throw new Exception("Array is not sorted");
		}

		center = (range / 2) + lower;

		if (bucket[center] == target) {
			return center;
		} else if (target < bucket[center]) {
			return binarySearch(bucket, target, lower, center - 1);
		} else {
			return binarySearch(bucket, target, center + 1, upper);
		}
	}

}
