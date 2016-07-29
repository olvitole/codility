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

	public static void print(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");

			n = n.next;
		}
		System.out.println();
	}

}
