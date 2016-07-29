package crackingthecoding;

import java.util.Hashtable;

import crackingthecoding.misc.Node;

/**
 * Write code to remove duplicates from an unsorted linked list. FOLLOW UP How
 * would you solve this problem if a temporary buffer is not allowed?
 */

public class Q2Dot1 {

	public static void main(String args[]) {

		Node nd = new Node(1);
		nd.appendToTail(1);
		nd.appendToTail(2);
		nd.appendToTail(3);
		nd.appendToTail(4);
		nd.appendToTail(5);

		print(nd);
		deleteDups(nd);
		print(nd);

		nd.appendToTail(5);
		print(nd);
		deleteDupsII(nd);
		print(nd);
	}

	public static void deleteDups(Node n) {
		Hashtable table = new Hashtable();
		Node previous = null;
		while (n != null) {
			System.out.println(n.data);
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
	
	// no buffer table to check against need to loop through
	public static void deleteDupsII(Node head) {
		if (head == null)
			return;

		Node current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");

			n = n.next;
		}
		System.out.println();
	}

}
