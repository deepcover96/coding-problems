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
		
	return populateBranch(arr, 0, arr.length - 1);
  }

  private static TreeNode populateBranch(int[] arr, int start, int end) {
  	int length = end - start;
	int middle = start + length/2;

	// this branch complete
	if (length < 0) return null;

	TreeNode node = new TreeNode(arr[middle]);
	System.out.println("val: " + node.getValue());

	TreeNode left  = populateBranch(arr, start, middle - 1);
	TreeNode right = populateBranch(arr, middle + 1, end);
	node.setLeft(left);
	node.setRight(right);

  	return node;
  }
}