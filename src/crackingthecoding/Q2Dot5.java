package crackingthecoding;

import crackingthecoding.misc.LinkedListNode;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1 's
 * digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list. FOLLOW UP Suppose the digits are stored
 * in forward order. Repeat the above problem.
 * 
 * 
 */

public class Q2Dot5 {

	private static final int BASE = 10;

	public static void main(String args[]) {

		LinkedListNode numberOne = new LinkedListNode(1);
		append(numberOne);

		LinkedListNode numberTwo = new LinkedListNode(1);
		append2(numberTwo);

		System.out.println();
		System.out.println("One: ");
		print(numberOne);
		print(numberTwo);

		LinkedListNode added = addNumbers(numberOne, numberTwo);
		print(added);

		System.out.println("Second");
		added = addNumbersII(numberOne, numberTwo);
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

}
