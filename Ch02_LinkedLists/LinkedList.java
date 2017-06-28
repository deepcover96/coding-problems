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
  private int length;

	// Singly-linked linked list
  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public Node getHead() { return head; }

  public void setHead(Node node) { head = node; }

  public int getLength() { return length; }

  public void append(Node node) {
    if (head == null) {
      this.head = node;
      this.tail = node;
      length = 1;
    } else {
      this.tail.setNext(node);
      while (this.tail.getNext() != null) {
        this.tail = tail.getNext();
        length += 1;

        // detect circular list
        if (tail.getNext() == node) {
          System.out.println("Failure: circular list detected.");
          this.head = null;
          return;
        }
      }
    }
  }



  // Remove current node from list, return it
  public Node removeNextNode(Node previous) {

    Node next = null;
    Node current = null;

    
    if (previous == null)
      current = head;  // if previous is null, we're removing head
    else 
      current = previous.getNext();

    if (current != null)
      next = current.getNext();  // get next node
    else
      return current;  // we have an empty

    // update head if this is the first node
    if (current == head)
      head = next;

    // update tail if this is the last node
    if (current == tail)
      tail = previous;

    // remove reference to removed node
    if (previous != null)
      previous.setNext(next);

    return current;
  }

  public int length() {
    Node n = head;
    int count = 0;
    while (n != null) {
      count += 1;
      n = n.getNext();
    }
    return count;
  }

  public void print() {
    Node n = head;

    while (n != null) {
      System.out.print(n.getVal() + " -> ");
      n = n.getNext();
    }

    System.out.println("null  (length: " + length + ")");
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
