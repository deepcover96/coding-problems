import java.util.*;

class Two {
  public static void main(String[] args) {
    
    LinkedList ll = LinkedList.createOrderedList();
    int k = 10;
    ll.print();


    System.out.print("Getting " + k + " from the last: ");
    System.out.println(getFromLast(ll, k));
    k = 9;
    System.out.print("Getting " + k + " from the last: ");
    System.out.println(getFromLast(ll, k));
    k = 5;
    System.out.print("Getting " + k + " from the last: ");
    System.out.println(getFromLast(ll, k));
    k = 4;
    System.out.print("Getting " + k + " from the last: ");
    System.out.println(getFromLast(ll, k));
    k = 1;
    System.out.print("Getting " + k + " from the last: ");
    System.out.println(getFromLast(ll, k));
    k = 0;
    System.out.print("Getting " + k + " from the last: ");
    System.out.println(getFromLast(ll, k));
    k = -1;
    System.out.print("Getting " + k + " from the last: ");
    System.out.println(getFromLast(ll, k));
  }

  // Return Kth to the Last: Implement an algorithm to find the Kth to the last 
  // element of a singly linked list
  // O (n)
  public static int getFromLast(LinkedList ll, int k) {
    int val = -1000;
    if (ll == null) return val;  // null-check list
    if (ll.getHead() == null) return val;  // check for empty list
    if (k < 0) return val;  // invalid index check

    Node nodeK = ll.getHead();
    Node nodeEnd = ll.getHead();

    // move the end pointer k places out
    for (int i = 0; i < k; i++) {
      nodeEnd = nodeEnd.getNext();
      if (nodeEnd == null)
        return val;  // out of bounds
    }

    // go through list until end node is at the tail of the list
    // increment both pointers
    while (nodeEnd.getNext() != null) {
      nodeK = nodeK.getNext();
      nodeEnd = nodeEnd.getNext();
    }

    // node k will land on n-k
    return nodeK.getVal();
  }
}
