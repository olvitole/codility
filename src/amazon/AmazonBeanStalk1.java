package amazon;

public class AmazonBeanStalk1 {

	public static void main(String args[]) {

		boolean rtn = isValidBST(null,Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(rtn);
	}

	public static boolean isValidBST(BinaryNode node, int MIN, int MAX) {
		if (node == null)
			return true;
		if (node.element > MIN && node.element < MAX && isValidBST(node.left, MIN, node.element)
				&& isValidBST(node.right, node.element, MAX))
			return true;
		else
			return false;
	}

	class BinaryNode {
		public int element;
		public BinaryNode left;
		public BinaryNode right;
	}
}
