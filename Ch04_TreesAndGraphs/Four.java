import java.util.*;



class Four {

  public static void main(String[] args) {
  	int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,20,45,55,56,67,69,100,111};

  	// create a binary tree using the method from problem Two.
  	TreeNode root = Two.createTree(arr);
  	TreeNode.print(root);
  	boolean balanced = checkBalanced(root);
  	System.out.println("Balanced: " + balanced);

  	TreeNode node7 = new TreeNode(7);
  	TreeNode node6 = new TreeNode(6);
  	TreeNode node5 = new TreeNode(5);
  	TreeNode node4 = new TreeNode(4);
  	TreeNode node3 = new TreeNode(3);
  	TreeNode node2 = new TreeNode(2);
  	TreeNode node1 = new TreeNode(1);

  	node5.setRight(node6);
  	node6.setRight(node7);
  	node5.setLeft(node3);
  	node3.setRight(node4);
  	node3.setLeft(node2);
  	node2.setLeft(node1);
  	TreeNode.print(node5);
  	balanced = checkBalanced(node5);
  	System.out.println("Balanced: " + balanced);
  }

  // Check Balanced: Implement a function to check if a binary tree is balanced.
  // For the purposes of this question, a balanced tree is defined to be a tree
  // such that the heights of the two subtrees never differ by more than one.
  public static boolean checkBalanced(TreeNode root) {
  	return (getDepth(root) != -1000);
  }

  private static int getDepth(TreeNode node) {
  	if (node == null) return -1;
  	int left = getDepth(node.getLeft());
  	if (left == -1000) return -1000;
  	int right = getDepth(node.getRight());
  	if (right == -1000) return -1000;
  	if (Math.abs(left - right) > 1) return -1000;

  	return Math.max(left, right) + 1;
  }
}