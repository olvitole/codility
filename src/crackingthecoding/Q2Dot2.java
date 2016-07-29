package crackingthecoding;

import crackingthecoding.misc.Node;

/**
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked
 * list.
 */

public class Q2Dot2 {

	public static void main(String args[]) {

		Node nd = new Node(1);
		nd.appendToTail(1);
		nd.appendToTail(2);
		nd.appendToTail(3);
		nd.appendToTail(4);
		nd.appendToTail(5);

		int n = 3;
		print(nd);
		System.out.println("One: ");
		int found = findNToLast(nd, n);
		System.out.println(found);

		System.out.println("A: ");
		nthToLast(nd, n);
		// prints from within otherwise will print last
		// System.out.println(found);

		System.out.println("B: ");
		// using C++ not feasible here

		System.out.println("C: ");
		Q2Dot2 x = new Q2Dot2();
		Node foundNd = x.nthToLastR2(nd, n, x.new IntWrapper());
		System.out.println(foundNd.data);

		System.out.println("D: ");
		foundNd = nthToLastD(nd, n);
		System.out.println(foundNd.data);

	}

	public static int findNToLast(Node nd, int n) {

		if (nd == null) {
			return 0;
		}

		int ln = findLenght(nd);

		System.out.println("lenght: " + ln);

		int navTo = ln - n;

		int index = 0;

		// assuming we start counting from 1
		while (nd != null && index < navTo) {

			index++;

			nd = nd.next;
		}

		return nd.data;
	}

	private static int findLenght(Node nd) {
		int ln = 0;

		while (nd != null) {
			ln++;
			nd = nd.next;
		}

		return ln;
	}

	// solved
	// A
	public static int nthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		}
		int i = nthToLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.data);
		}
		return i;
	}

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");

			n = n.next;
		}
		System.out.println();
	}

	// solved C

	public class IntWrapper {
		public int value = 0;
	}

	public static Node nthToLastR2(Node head, int k, IntWrapper i) {
		if (head == null) {
			return null;
		}
		Node node = nthToLastR2(head.next, k, i);
		i.value = i.value + 1;
		if (i.value == k) { // We've found the kth element
			return head;
		}
		return node;
	}

	// solution D
	public static Node nthToLastD(Node head, int k) {
		if (k <= 0)
			return null;

		Node p1 = head;
		Node p2 = head;

		// Move p2 -forward k nodes into the list.
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return null; // Error check
			p2 = p2.next;
		}
		if (p2 == null)
			return null;

		/*
		 * Now, move pi and p2 at the same speed. When p2 hits the end, pi will
		 * be at the right element.
		 */
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

}
