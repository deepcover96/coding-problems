import java.util.*;



class LinkedList {

  public static void main(String[] args) {
    
    LinkedList ll = new LinkedList();
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);

    ll.append(one);
    ll.append(two);
    ll.append(three);
    ll.print();

    ll = createList();
    ll.print();
    ll = createOrderedList();
    ll.print();

  }

  private Node tail;
  private Node head;

	// Singly-linked linked list
  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  public Node getHead() { return head; }

  public void append(Node node) {
    if (head == null) {
      this.head = node;
    } else {
      this.tail.setNext(node);
    }

    this.tail = node;
  }

  public void print() {
    Node n = head;

    while (n != null) {
      System.out.print(n.getVal() + " -> ");
      n = n.getNext();
    }

    System.out.println("null");
  }



  public static LinkedList createList() {
    LinkedList ll = new LinkedList();
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node three1 = new Node(3);
    Node three2 = new Node(3);
    Node three3 = new Node(3);
    Node two2 = new Node(2);

    ll.append(two);
    ll.append(one);
    ll.append(three);
    ll.append(three3);
    ll.append(two2);
    ll.append(three1);
    ll.append(three2);

    return ll;
  }
  public static LinkedList createOrderedList() {
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

    return ll;
  }
}


class Node {
  private int val;
  private Node next;

  public Node(int val) {
    next = null;
    this.val = val;
  }

  public int getVal() { return val; }
  public void setVal(int val) { this.val = val; } 
  public Node getNext() { return next; }
  public void setNext(Node next) { this.next = next; }


}
