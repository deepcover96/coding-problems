import java.util.*;

class Six {
  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node one1 = new Node(1);
    Node two1 = new Node(2);
    Node three1 = new Node(3);

    ll.append(one);
    ll.append(two);
    ll.append(three);
    ll.append(four);
    ll.append(three1);
    ll.append(two1);
    ll.append(one1);
    ll.print();

    boolean p = isPalindrone(ll);
    System.out.println(" Is Palindrone? " + p);

    ll.removeNextNode(three);
    ll.print();

    p = isPalindrone(ll);
    System.out.println(" Is Palindrone? " + p);

    ll.removeNextNode(three);
    ll.print();

    p = isPalindrone(ll);
    System.out.println(" Is Palindrone? " + p);

    ll.removeNextNode(two1);
    ll.print();
    p = isPalindrone(ll);
    System.out.println(" Is Palindrone? " + p);

    LinkedList ll2 = new LinkedList();
    Node nine = new Node(9); 
    ll2.append(nine);
    ll2.print();
    p = isPalindrone(ll2);
    System.out.println(" Is Palindrone? " + p);

    ll2.removeNextNode(null);
    ll2.print();
    p = isPalindrone(ll2);
    System.out.println(" Is Palindrone? " + p);
  }



  // Palindrone: Implement a function to check if a linked list is a palidrone
  public static boolean isPalindrone(LinkedList ll) {
    if (ll == null) return false;  // null check
    Node head = ll.getHead();      // get head
    // we have an empty list or a single item, return true;
    if (head == null || head.getNext() == null) return true; 

    Node n = isPalindroneRecurse(head.getNext(), head); 
    if (n == null) return false;  // recursive calls did not match every node

    return true;
  }

  // R1 -> A1 -> C1 -> E -> C2 -> A2 -> R2 -> null
  // We pass the each successive node down the stack, as well as the head until we hit the end.
  // We then compare the opposing nodes, in this case the head to the tail. (R1 == R2)
  // If they match, return head->nextNode() which is A1; otherwise return null
  // Up the stack we will compare A1 and A2, and so on until we are back at the head
  private static Node isPalindroneRecurse(Node current, Node head) {
    Node oNode = null;  // opposing node, which we will compare to current
    Node next = current.getNext();
    Node result = null;  // starts off as failed match

    if (next == null)
      oNode = head;  // we are at the tail, we will compare against head
    else
      oNode = isPalindroneRecurse(next, head);

    // if recursive function returned null, we are not a palindrone
    if (oNode != null) {
      if (oNode.getVal() == current.getVal()) {
        result = front.getNext();  // good match
      }
    }

    return result;
  }
}