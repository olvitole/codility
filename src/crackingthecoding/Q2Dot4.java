package crackingthecoding;

import crackingthecoding.misc.LinkedListNode;

/**
 * 2.4 Write code to partition a linked list around a value x, such that all
 * nodes less than x come before all nodes greater than or equal to x.
 * 
 */

public class Q2Dot4 {

	public static void main(String args[]) {

		LinkedListNode nd = new LinkedListNode(1);
		nd.appendToTail(1);
		nd.appendToTail(5);
		nd.appendToTail(3);
		nd.appendToTail(2);
		nd.appendToTail(5);
		nd.appendToTail(6);
		nd.appendToTail(4);

		System.out.println();
		System.out.println("One: ");
		print(nd);
		int x = 4;
		partition(nd, x);
		print(nd);

	}

	public static void partition(LinkedListNode nd, int x) {

		LinkedListNode less = null;
		LinkedListNode more = null;

		LinkedListNode moreI = null;

		while (nd != null) {

			if (nd.data < x) {
				if (less == null) {
					less = nd;
				} else {
					less.next = nd;
					less = less.next;
				}
			} else {
				if (more == null) {
					more = nd;
					moreI = nd;
				} else {
					more.next = nd;
					more = more.next;
				}
			}
			nd = nd.next;
		}

		if (less == null) {
			nd = moreI;
		} else {
			less.next = moreI;
			nd = less;
		}
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

}
