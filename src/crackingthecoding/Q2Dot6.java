package crackingthecoding;

import crackingthecoding.misc.LinkedListNode;

/**
 * 2.6 Palindrome: Implement a function to check if a linked list is a
 * palindrome.
 */

public class Q2Dot6 {

	public static void main(String args[]) {

		LinkedListNode nd = new LinkedListNode(1);
		append(nd);

		System.out.println();
		System.out.println("Case: ");
		print(nd);
		Q2Dot6 prob = new Q2Dot6();
		boolean isPal = prob.isPalindrome(nd);
		System.out.println("Answer: " + isPal);

	}

	private static void append(LinkedListNode nd) {
		nd.appendToTail(2);
		//nd.appendToTail(6);
		nd.appendToTail(2);
		//nd.appendToTail(1);
		nd.appendToTail(1);
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

	public boolean isPalindrome(LinkedListNode nd) {

		if (nd == null || nd.next == null)
			return false;

		Result rslt = reverse(nd);

		LinkedListNode reversed = rslt.nd;
		int count = rslt.count;

		int i = 0;

		if (count % 2 == 1)
			count++;

		count = count / 2;

		while (nd != null && i < count) { // no need to check reversed due
												// to
												// same lenght
			if (nd.data != reversed.data)
				return false;
			nd = nd.next;
			reversed = reversed.next;
			i++;
		}

		return true;
	}

	private Result reverse(LinkedListNode nd) {

		Result rs = new Result();

		LinkedListNode reversed = null;

		int count = 0;

		while (nd != null) {
			LinkedListNode n = new LinkedListNode(nd.data); // Clone
			n.next = reversed;
			reversed = n;
			nd = nd.next;
			count++;
		}

		print(reversed);
		
		rs.count = count;
		rs.nd = reversed;

		return rs;
	}

	class Result {

		LinkedListNode nd;
		int count;

	}
	
	
	// Solution on book same as mine

}
