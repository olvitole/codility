package crackingthecoding;

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

public class Q2Dot5B {

	private static int length(LinkedListNodeB l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}

	private static PartialSum addListsHelper(LinkedListNodeB l1, LinkedListNodeB l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		LinkedListNodeB full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	private static LinkedListNodeB addLists(LinkedListNodeB l1, LinkedListNodeB l2) {
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
			LinkedListNodeB result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	private static LinkedListNodeB padList(LinkedListNodeB l, int padding) {
		LinkedListNodeB head = l;
		for (int i = 0; i < padding; i++) {
			LinkedListNodeB n = new LinkedListNodeB(0, null, null);
			head.prev = n;
			n.next = head;
			head = n;
		}
		return head;
	}

	private static LinkedListNodeB insertBefore(LinkedListNodeB list, int data) {
		LinkedListNodeB node = new LinkedListNodeB(data, null, null);
		if (list != null) {
			list.prev = node;
			node.next = list;
		}
		return node;
	}

	public static int linkedListToInt(LinkedListNodeB node) {
		int value = 0;
		while (node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}

	public static void main(String[] args) {
		
		// 1 1 6 6 

		LinkedListNodeB lA1 = new LinkedListNodeB(1, null, null);
		LinkedListNodeB lA2 = new LinkedListNodeB(1, null, lA1);
		LinkedListNodeB lA3 = new LinkedListNodeB(6, null, lA2);
		LinkedListNodeB lA4 = new LinkedListNodeB(6, null, lA3);

		//2 2 1 0 3 5 6 4 
		LinkedListNodeB lB1 = new LinkedListNodeB(2, null, null);
		LinkedListNodeB lB2 = new LinkedListNodeB(2, null, lB1);
		LinkedListNodeB lB3 = new LinkedListNodeB(1, null, lB2);
		LinkedListNodeB lB4 = new LinkedListNodeB(0, null, lB3);
		LinkedListNodeB lB5 = new LinkedListNodeB(3, null, lB4);
		LinkedListNodeB lB6 = new LinkedListNodeB(5, null, lB5);
		LinkedListNodeB lB7 = new LinkedListNodeB(6, null, lB6);
		LinkedListNodeB lB8 = new LinkedListNodeB(4, null, lB7);

		LinkedListNodeB list3 = addLists(lA1, lB1);

		System.out.println("  " + lA1.printForward());
		System.out.println("+ " + lB1.printForward());
		System.out.println("= " + list3.printForward());

		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);

		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
	}
}
