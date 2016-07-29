package crackingthecoding;

import java.util.Hashtable;

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
		int found = findNToLast(nd, n);
		System.out.println(found);
	}

	public static int findNToLast(Node nd, int n) {

		if (nd == null) {
			return -1;
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

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");

			n = n.next;
		}
		System.out.println();
	}

}
