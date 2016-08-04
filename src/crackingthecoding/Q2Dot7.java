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

}
