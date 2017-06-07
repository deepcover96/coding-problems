import java.util.*;

class One {
  public static void main(String[] args) {
    
    LinkedList ll = LinkedList.createList();
    ll.print();
    removeDuplicates(ll);
    ll.print();
    removeDuplicates(ll);
    ll.print();


    ll = LinkedList.createList();
    ll.print();
    removeDuplicatesInPlace(ll);
    ll.print();
    removeDuplicatesInPlace(ll);
    ll.print();
  }

  // Remove Dups: Write code to remove duplicates from an unsorted linked list
  // O (n)
  public static void removeDuplicates(LinkedList ll) {
    if (ll == null) return;  // null-check list
    // use a hashset to check uniqueness
    Set set = new HashSet();
    Node n = ll.getHead();  // get first node


    if (n == null) return;  // null-check first node
    Node prev = n;          // set previous node
    set.add(n.getVal());             // add to hashset
    n = n.getNext();        // get next node

    while (n != null) {
      if (set.add(n.getVal())) {
        prev = n;  // this is unique, keep going
      } else {
        prev.setNext(n.getNext());  // skip over n
      }
      n = n.getNext();
    }
  }


  // Remove Dups: Do this without using a temporary buffer
  // So no hashmap
  // O (n^2)
  public static void removeDuplicatesInPlace(LinkedList ll) {
    if (ll == null) return;  // null-check list
    Node n = ll.getHead();   // get head

    while (n != null) {
      removeDuplicatesOfSingleNode(n);
      n = n.getNext();
    }
  }


  private static void removeDuplicatesOfSingleNode(Node node) {
    int val = node.getVal();
    Node prev = node;          // set previous node
    Node n = node.getNext();

    while (n != null) {
      if (n.getVal() != val) {
        prev = n;  // this is unique, keep going
      } else {
        prev.setNext(n.getNext());  // skip over n
      }
      n = n.getNext();
    }
  }


}
