package crackingthecoding;

import crackingthecoding.misc.LinkedListNode;

/**
 * 2.7 Intersection: Given two (singly) linked lists, determine if the two lists
 * intersect. Return the intersecting node. Note that the intersection is
 * defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the
 * second linked list, then they are intersecting.
 */

public class Q2Dot7 {

	public static void main(String args[]) {

		LinkedListNode nd = new LinkedListNode(1);
		append(nd);

		LinkedListNode one = new LinkedListNode(4);
		one.appendToTail(4);
		one.appendToTail(nd);

		LinkedListNode two = new LinkedListNode(4);
		two.appendToTail(5);
		two.appendToTail(5);
		two.appendToTail(5);
		two.appendToTail(5);
		two.appendToTail(nd);

		System.out.println();
		System.out.println("Case: ");
		print(one);
		print(two);
		Q2Dot7 prob = new Q2Dot7();

		LinkedListNode node = prob.intersect(one, two);
		System.out.println("Answer: ");
		print(node);

		LinkedListNode node2 = prob.findintersection(one, two);
		System.out.println("Answer2: ");
		print(node2);

	}

	private static void append(LinkedListNode nd) {
		nd.appendToTail(2);
		// nd.appendToTail(6);
		nd.appendToTail(2);
		// nd.appendToTail(1);
		nd.appendToTail(1);
	}

	public static void print(LinkedListNode n) {
		System.out.println("Printing begin: ");
		while (n != null) {
			System.out.print(n.data + " ");

			n = n.next;
		}
		System.out.println();
		System.out.println("Printing end. ");
	}

	public LinkedListNode intersect(LinkedListNode one, LinkedListNode two) {

		int lenOne = length(one);
		int lenTwo = length(two);

		if (lenOne > lenTwo) {
			while (lenOne != lenTwo) {
				lenOne--;
				one = one.next;
			}
		} else if (lenTwo > lenOne) {
			while (lenOne != lenTwo) {
				lenTwo--;
				two = two.next;
			}
		}

		while (one != null) {

			if (one.equals(two))
				return one;
			one = one.next;
			two = two.next;
		}
		return null;
	}

	private int length(LinkedListNode nd) {

		int count = 0;
		while (nd != null) {
			count++;
			nd = nd.next;
		}

		return count;
	}

	// Solution on book same as mine

	// Solution A

	LinkedListNode findintersection(LinkedListNode listl, LinkedListNode list2) {
		if (listl == null || list2 == null)
			return null;

		/* Get tail and sizes. */
		Result resultl = getTailAndSize(listl);
		Result result2 = getTailAndSize(list2);
		/* If different tail nodes, then there's no intersection. */
		if (resultl.tail != result2.tail) {
			return null;
		}
		/* Set pointers to the start of each linked list. */
		LinkedListNode shorter = resultl.size < result2.size ? listl : list2;
		LinkedListNode longer = resultl.size < result2.size ? list2 : listl;
		/*
		 * Advance the pointer for the longer linked list by difference in
		 * lengths.
		 */
		longer = getKthNode(longer, Math.abs(resultl.size - result2.size));
		/* Move both pointers until you have a collision. */
		while (shorter != longer) {

			shorter = shorter.next;
			longer = longer.next;
		}
		/* Return either one. */
		return longer;

	}

	class Result {
		public LinkedListNode tail;
		public int size;

		public Result(LinkedListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	Result getTailAndSize(LinkedListNode list) {
		if (list == null)
			return null;

		int size = 1;
		LinkedListNode current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}

	LinkedListNode getKthNode(LinkedListNode head, int k) {
		LinkedListNode current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}

}
