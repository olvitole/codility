package amazon;

public class AmazonBeanStalk1 {

	public static void main(String args[]) {

		boolean rtn = isValidBinarySearchTree(null, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(rtn);
	}

	public static boolean isValidBinarySearchTree(BinaryNode node, int MIN, int MAX) {
		if (node == null)
			return true;
		return node.element > MIN && node.element < MAX && isValidBinarySearchTree(node.left, MIN, node.element)
				&& isValidBinarySearchTree(node.right, node.element, MAX);
	}

	class BinaryNode {
		public int element;
		public BinaryNode left;
		public BinaryNode right;
	}
}
