import java.util.*;



class Five {

  public static void main(String[] args) {
  	int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,20,45,55,56,67,69,100,111};

  	// create a binary tree using the method from problem Two.
  	TreeNode root = Two.createTree(arr);
  	TreeNode.print(root);
  	boolean isBst = isBinarySearchTree(root);
  	System.out.println("Is BST: " + isBst);

  	TreeNode node7 = new TreeNode(7);
  	TreeNode node6 = new TreeNode(6);
  	TreeNode node5 = new TreeNode(5);
  	TreeNode node4 = new TreeNode(4);
  	TreeNode node3 = new TreeNode(3);
  	TreeNode node2 = new TreeNode(2);
  	TreeNode node1 = new TreeNode(1);
    TreeNode node0 = new TreeNode(0);

  	node5.setRight(node6);
  	node6.setRight(node7);
    //node6.setLeft(node0);  // makes it fail
  	node5.setLeft(node3);
  	node3.setRight(node4);
  	node3.setLeft(node2);
  	node2.setLeft(node1);
  	TreeNode.print(node5);
  	isBst = isBinarySearchTree(node5);
  	System.out.println("Is BST: " + isBst);
  }

  // Validate BST: Implement a function to check if a binary tree is a
  // binary search tree.
  public static boolean isBinarySearchTree(TreeNode root) {
  	return isBst(root, null, null);
  }

  private static boolean isBst(TreeNode node, Integer low, Integer high) {
    if (node == null) return true;
    int val = node.getValue();
    if (low != null && val <= low) return false;
    if (high != null && val > high) return false;

    boolean left = isBst(node.getLeft(), low, node.getValue());
    boolean right = isBst(node.getRight(), node.getValue(), high);

    return left && right;
  }

}