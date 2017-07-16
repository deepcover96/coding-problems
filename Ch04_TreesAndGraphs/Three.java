import java.util.*;



class Three {

  public static void main(String[] args) {
  	int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,20,45,55,56,67,69,100,111};

  	// create a binary tree using the method from problem Two.
  	TreeNode root = Two.createTree(arr);
  	TreeNode.print(root);

  	List<LinkedList<TreeNode>> list = listOfDepths(root);

  	for (LinkedList<TreeNode> ll : list) {
  		for (TreeNode node : ll) {
  			System.out.print(node.getValue() + " ---> ");
  		}
  		System.out.println();
  	}

  }

  // List of Depths: Given a binary tree, design an algorithm which creates linked lists
  // of all the nodes at each depth (e.g. if you have a tree with depth D, you'll have 
  // D linked lists).
  public static List<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
  	if (root == null) return null;
  	// A List of linked lists
  	// Each item in the list will hold a linked list of the tree level.
  	List<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		
  	getNodesByDepth(root, list, 0);
  	return list;
  }

  private static void getNodesByDepth(TreeNode node, List<LinkedList<TreeNode>> list, int level) {
  	if (node == null) return;

  	LinkedList<TreeNode> ll = null;

  	// check if linked list already exists
  	if (list.size() < level + 1){
  		ll = new LinkedList<TreeNode>();
  		list.add(ll);
  	} else {
  		ll = list.get(level);
  	}

  	ll.add(node);  // add node

  	level += 1;  //increment level

  	// get nodes for next level down
  	getNodesByDepth(node.getLeft(), list, level);
  	getNodesByDepth(node.getRight(), list, level);

  }
}