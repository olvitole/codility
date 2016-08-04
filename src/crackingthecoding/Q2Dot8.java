package crackingthecoding;

import crackingthecoding.misc.LinkedListNode;

/**
 * 2.8 Find circular node
 */

public class Q2Dot8 {

	public static void main(String args[]) {

		LinkedListNode nd = new LinkedListNode(1);
		append(nd);

		// note for this test case to work there need two be at least two nodes
		nd.appendToTail(nd);

		System.out.println();
		System.out.println("Case: ");
		System.out.println("The start node is:" + nd.data);
		Q2Dot8 prob = new Q2Dot8();

		LinkedListNode node = prob.find(nd);
		System.out.println("Answer: ");
		System.out.println("The node is:" + node.data);

		LinkedListNode node2 = prob.findBeginning(nd);
		System.out.println("Book Answer: ");
		System.out.println("The node is:" + node2.data);

	}

	private static void append(LinkedListNode nd) {
		nd.appendToTail(2);
		nd.appendToTail(3);
		nd.appendToTail(4);
		nd.appendToTail(5);
		nd.appendToTail(6);
		nd.appendToTail(7);
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

	
	// revise does not work
	public LinkedListNode find(LinkedListNode nd) {

		int innerCnt = 0;
		int outerCnt = 0;

		LinkedListNode fixed = nd;
		LinkedListNode inner = nd;
		LinkedListNode outer = nd;

		boolean foundOut = false;
		boolean foundIn = false;

		while (!foundOut) {
			while (!foundIn) {

				if (inner.next.equals(outer.next) && innerCnt != outerCnt) {
					foundOut = true;
					foundIn = true;
				}

				inner = inner.next;

				if (innerCnt == outerCnt)
					foundIn = true;
			}
			// reset inner cursor
			innerCnt = 0;
			inner = fixed;
			foundIn = false;

			outer = outer.next;

			outerCnt++;
		}

		return outer;

	}

	
	// book proper solution
	
	LinkedListNode findBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		/*
		 * Find meeting point. This will be LOOP_SIZE - k steps into the linked
		 * list.
		 */
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {// Collision
				break;
			}
		}

		/* Error check - no meeting point, and therefore no loop */
		if (fast == null || fast.next == null) {
			return null;
		}

		/*
		 * Move slow to Head. Keep fast at Meeting Point. Each are k steps from
		 * the Loop Start. If they move at the same pace, they must meet at Loop
		 * Start .
		 */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		/* Both now point to the start of the loop. */
		return fast;
	}

}
