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

		print(nd);
		System.out.println("One: ");
		

	}

	public static void print(LinkedListNode n) {
		while (n != null) {
			System.out.print(n.data + " ");

			n = n.next;
		}
		System.out.println();
	}

}
