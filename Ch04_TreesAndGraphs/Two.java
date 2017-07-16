import java.util.*;



class Two {

  public static void main(String[] args) {
  	int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,20,45,55,56,67,69,100,111};

  	TreeNode root = createTree(arr);
  	TreeNode.print(root);
  }

  // Minimal Tree: Given a sorted (increasing order) array with unique integer
  // elements, write an algorithm to create a binary search tree with minimal height.
  public static TreeNode createTree(int[] arr) {
  	if (arr == null || arr.length == 0) return null;
  	TreeNode node = new TreeNode();
		
	return populateBranch(arr, 0, arr.length - 1, node);
  }

  private static TreeNode populateBranch(int[] arr, int start, int end, TreeNode node) {
  	int length = end - start + 1;
	int middle = start + length/2;

	node.setValue(arr[middle]);
	System.out.println("val: " + arr[middle]);

	// we have at least 1 left-sede node
	if (length > 1) {
		node.setLeft(new TreeNode());
		populateBranch(arr, start, middle - 1, node.getLeft());
	}

	// if > 2, then we will have at least one right-side node too.
	if (length > 2) {
		node.setRight(new TreeNode());
		populateBranch(arr, middle + 1, end, node.getRight());
	}

  	return node;
  }
}