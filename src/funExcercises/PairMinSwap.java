package funExcercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

There are n-pairs and therefore 2n people. 
everyone has one unique number ranging from 1 to 2n. 
All these 2n persons are arranged in random fashion in an Array of size 2n. 
We are also given who is partner of whom. 
Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.

Example:

Input:
n = 3  
pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
arr[] = {3, 5, 6, 4, 1, 2}

Output: 2
We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1

 */

class Pair {
	public Pair(int i, int j) {
		left = i;
		right = j;
	}

	int left;
	int right;
}

// http://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/

public class PairMinSwap {

	private Map<Integer, Integer> pairMap = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

	private void createPairMap(List<Pair> pairs) {
		for (int i = 0; i < pairs.size(); i++) {
			pairMap.put(pairs.get(i).left, pairs.get(i).right);
			pairMap.put(pairs.get(i).right, pairs.get(i).left);
		}
	}

	private void createIndexMap(int[] randomArray) {
		for (int i = 0; i < randomArray.length; i++) {
			indexMap.put(randomArray[i], i);
		}
	}

	private void swap(int[] randomArray, int element1, int element2) {
		int element1Index = indexMap.get(element1);
		int element2Index = indexMap.get(element2);

		randomArray[element2Index] = element1;
		randomArray[element1Index] = element2;

		indexMap.put(element1, element2Index);
		indexMap.put(element2, element1Index);
	}

	public int minNoOfSwapRequired(int[] randomArray, List<Pair> pairs) {
		int noOfTimesSwap = 0;

		createPairMap(pairs);
		createIndexMap(randomArray);

		int i = 0;
		while (i < randomArray.length) {
			int element = randomArray[i];
			int peek = randomArray[i + 1];

			int elePair = pairMap.get(element);
			if (peek != elePair) {
				swap(randomArray, peek, elePair);
				noOfTimesSwap++;
			}

			i = i + 2;
		}

		return noOfTimesSwap;
	}

	public static void main(String args[]) {

		List<Pair> pairs1 = new ArrayList<Pair>();
		int[] randomArray1 = new int[] { 3, 5, 6, 4, 1, 2 };
		int[] randomArray2 = new int[] { 3, 6, 5, 4, 1, 2 };
		int[] randomArray3 = new int[] { 3, 1, 5, 4, 6, 2 };

		Pair pair1 = new Pair(1, 3);
		Pair pair2 = new Pair(2, 6);
		Pair pair3 = new Pair(4, 5);

		pairs1.add(pair1);
		pairs1.add(pair2);
		pairs1.add(pair3);
		
		// 2 1 0
		PairMinSwap pms = new PairMinSwap();
		System.out.println(pms.minNoOfSwapRequired(randomArray1, pairs1));

		pms = new PairMinSwap();
		System.out.println(pms.minNoOfSwapRequired(randomArray2, pairs1));

		pms = new PairMinSwap();
		System.out.println(pms.minNoOfSwapRequired(randomArray3, pairs1));
	}

}