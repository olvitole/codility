package crackingthecoding;

import crackingthecoding.misc.LinkedListNode;

/**
 * 2.4 Write code to partition a linked list around a value x, such that all
 * nodes less than x come before all nodes greater than or equal to x.
 * 
 */

public class Q2Dot4 {

	public static void main(String args[]) {

		int x = 4;

		LinkedListNode nd = new LinkedListNode(1);
		append(nd);

		System.out.println();
		System.out.println("One: ");
		print(nd);
		partition(nd, x);
		print(nd);

		// test for book
		nd = new LinkedListNode(1);
		append(nd);

		System.out.println();
		System.out.println("Book: ");
		print(nd);
		LinkedListNode ndR = partitionS(nd, x);
		print(ndR);

		// test for book B
		nd = new LinkedListNode(1);
		append(nd);

		System.out.println();
		System.out.println("Book B: ");
		print(nd);
		ndR = partitionSII(nd, x);
		print(ndR);

	}

	private static void append(LinkedListNode nd) {
		nd.appendToTail(1);
		nd.appendToTail(5);
		nd.appendToTail(3);
		nd.appendToTail(2);
		nd.appendToTail(5);
		nd.appendToTail(6);
		nd.appendToTail(4);
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

	// Solved A

	/*
	 * Pass in the head of the linked list and the value to partition around
	 */
	public static LinkedListNode partitionS(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;

		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				/* Insert node into end of before list */
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				/* Insert node into end of after list */
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		if (beforeStart == null) {
			return afterStart;
		}

		/* Merge before list and after list */
		beforeEnd.next = afterStart;
		return beforeStart;
	}

	// Solved B

	public static LinkedListNode partitionSII(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;

		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node into start of before list */
				node.next = beforeStart;
				beforeStart = node;
			} else {
				/* Insert node into front of after list */
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
		}

		/* Merge before list and after list */

		if (beforeStart == null) {
			return afterStart;
		}

		/* Find end of before list, and merge the lists */
		LinkedListNode head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;

		return head;
	}

}
