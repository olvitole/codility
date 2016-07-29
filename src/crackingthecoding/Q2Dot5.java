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
		nd.appendToTail(3);

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

			if (added == null) {
				added = new LinkedListNode(sum);
			} else
				added.appendToTail(sum);
		}

		return added;

	}

}
