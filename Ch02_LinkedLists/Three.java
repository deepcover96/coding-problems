import java.util.*;

class Three {
  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);

    ll.append(one);
    ll.append(two);
    ll.append(three);
    ll.append(four);
    ll.append(five);
    ll.append(six);
    ll.append(seven);

    ll.print();


    System.out.println("removing " + five.getVal());
    removeNode(five);
    ll.print();

  }

  // Delete Middle Node: Implement an algorithm to delete a node in the middle
  // (i.e. any node but the first and last node, not necessarily the exact middle)
  // of a singly linked list, given only access to that node.
  // O (n)
  public static boolean removeNode(Node node) {
    if (node == null || node.getNext() == null) return false;

    // copy over the value from the next node
    node.setVal(node.getNext().getVal());
    
    // then skip the next node
    node.setNext(node.getNext().getNext());
    return true;
  }
}
