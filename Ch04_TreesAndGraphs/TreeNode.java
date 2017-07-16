import java.util.*;



class TreeNode {
	private int value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode() {
		left = null;
		right = null;
	}

	public TreeNode(int value) {
		this.value = value;
		left = null;
		right = null;
	}

	public int getValue() { return value; }
	public void setValue(int value) { this.value = value; }
	public TreeNode getLeft() { return left; }
	public TreeNode getRight() { return right; }
	public void setLeft(TreeNode node) { left = node; }
	public void setRight(TreeNode node) { right = node; }

	public static void print(TreeNode node) {
		int depth = 1;
		int count = 1;

		while (count > 0) {
			count = printLevel(depth, node);
			depth += 1;
			System.out.println();
		}
	}

	private static int printLevel(int depth, TreeNode node) {
		if (node == null) return 0;
		if (depth <= 1) {
			System.out.print(node.getValue() + " ");
			return 1;
		} else {
			depth -= 1;
			int left = printLevel(depth, node.getLeft());
			int right = printLevel(depth, node.getRight());
			return right + left;
		}
	}
}