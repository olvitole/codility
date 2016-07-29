package crackingthecoding;

import crackingthecoding.misc.LinkedListNode;

/**
 * 2.3 Implement an algorithm to delete a node in the middle of a singly linked
 * list, given only access to that node.
 */

public class Q2Dot3 {

	public static void main(String args[]) {

		LinkedListNode nd = new LinkedListNode(1);
		nd.appendToTail(1);
		nd.appendToTail(2);
		nd.appendToTail(3);
		nd.appendToTail(4);
		nd.appendToTail(5);

		System.out.println();
		System.out.println("One: ");
		print(nd);
		deleteNode(nd);
		print(nd);

		LinkedListNode nd2 = null;
		System.out.println();
		System.out.println("Two: ");
		print(nd2);
		deleteNode(nd2);
		print(nd2);

		LinkedListNode nd3 = new LinkedListNode(1);
		System.out.println();
		System.out.println("Three: ");
		print(nd3);
		deleteNode(nd3);
		print(nd3);

	}

	public static void deleteNode(LinkedListNode nd) {

		// will never occur because the requirements say we are in the middle
		if (nd == null || nd.next == null) {
			System.out.println("Nothing deleted invalid scenario");
			return;
		}

		nd.data = nd.next.data;
		nd.next = nd.next.next;

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
