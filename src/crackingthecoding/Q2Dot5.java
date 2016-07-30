package crackingthecoding;

import crackingthecoding.misc.LinkedListNode;
import crackingthecoding.misc.LinkedListNodeB;
import crackingthecoding.misc.PartialSum;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit.
 * 
 * The digits are stored in reverse order, such that the Ts digit is at the head
 * of the list.
 * 
 * Write a function that adds the two numbers and returns the sum as a linked
 * list.
 * 
 * EXAMPLE Input: (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295. Output: 2 ->
 * 1 -> 9.That is, 912.
 * 
 * FOLLOW UP Suppose the digits are stored in forward order. Repeat the above
 * problem.
 * 
 * EXAMPLE Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295. Output: 9
 * -> 1 -> 2.That is, 912.
 */

public class Q2Dot5 {

	private static final int BASE = 10;

	public static void main(String args[]) {

		LinkedListNode numberOne = new LinkedListNode(1);
		append(numberOne);

		LinkedListNode numberTwo = new LinkedListNode(1);
		append2(numberTwo);

		System.out.println();
		System.out.println("OT: ");
		print(numberOne);
		print(numberTwo);

		LinkedListNode added = addNumbers(numberOne, numberTwo);
		print(added);

		System.out.println("OT2: ");
		// this will mess up one and two and set them to the first element
		added = addNumbersII(numberOne, numberTwo);
		print(added);

		System.out.println("Book: ");
		numberOne = new LinkedListNode(1);
		append(numberOne);
		numberTwo = new LinkedListNode(1);
		append2(numberTwo);
		added = addLists(numberOne, numberTwo, 0);
		print(added);

		System.out.println("Book2: ");
		numberOne = new LinkedListNode(1);
		append(numberOne);
		numberTwo = new LinkedListNode(1);
		append2(numberTwo);
		print(numberTwo);
		print(added);
		Q2Dot5 p = new Q2Dot5();
		added = p.addLists(numberOne, numberTwo);
		print(added);

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

	private static void append2(LinkedListNode nd) {
		nd.appendToTail(1);
		nd.appendToTail(6);
		nd.appendToTail(6);

	}

	public static void print(LinkedListNode n) {
		System.out.println("Printing begin: ");
		while (n != null) {
			System.out.print(n.data + " ");

			n = n.next;
		}
		System.out.println();
		System.out.println("Printing end. ");
		System.out.println("---------------");

	}

	public static LinkedListNode addNumbers(LinkedListNode one, LinkedListNode two) {

		LinkedListNode added = null;

		if (one == null)
			return two;

		if (two == null)
			return one;

		int inMind = 0;

		while (one != null || two != null) {
			int sum = 0;
			if (one != null && two != null) {
				sum = one.data + two.data;
				one = one.next;
				two = two.next;
			} else {
				if (one == null) {
					sum = two.data;
					two = two.next;
				} else if (two == null) {
					sum = one.data;
					one = one.next;
				}
			}

			sum += inMind;
			int newSum = sum;
			if (newSum >= BASE) {
				newSum = sum % BASE;
			}

			if (added == null) {
				added = new LinkedListNode(newSum);
			} else {
				added.appendToTail(newSum);
			}
			inMind = sum / BASE;
		}

		return added;

	}

	// this one the order is reversed so we can just reverse the linked list
	// and reuse the method created above for addition.
	public static LinkedListNode addNumbersII(LinkedListNode one, LinkedListNode two) {

		LinkedListNode oneR = reverse(one);
		LinkedListNode twoR = reverse(two);
		print(oneR);
		print(twoR);
		return addNumbers(oneR, twoR);
	}

	private static LinkedListNode reverse(LinkedListNode node) {

		if (node == null || node.next == null) {
			return node;
		}

		LinkedListNode remaining = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;

	}

	public static LinkedListNode reverseII(LinkedListNode currentNode) {
		// For first node, previousNode will be null
		LinkedListNode previousNode = null;
		LinkedListNode nextNode;
		while (currentNode != null) {
			nextNode = currentNode.next;
			// reversing the link
			currentNode.next = previousNode;
			// moving currentNode and previousNode by 1 node
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}

	// Solution A

	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		/* We're done if both lists are null AND the carry value is 0 */
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		LinkedListNode result = new LinkedListNode(carry);

		/* Add value, and the data from i1 and i2 */
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}

		result.data = value % 10; /* Second digit of number */

		/* Recurse */
		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
					value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	// solution B

	public class PartialSum {
		public LinkedListNode sum = null;
		public int carry = 0;
	}

	private int length(LinkedListNode l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}

	private PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	private LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		PartialSum sum = addListsHelper(l1, l2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	private LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			LinkedListNode n = new LinkedListNode(0);
			head.prev = n;
			n.next = head;
			head = n;
		}
		return head;
	}

	private LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if (list != null) {
			list.prev = node;
			node.next = list;
		}
		return node;
	}

	public int linkedListToInt(LinkedListNode node) {
		int value = 0;
		while (node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}

}
