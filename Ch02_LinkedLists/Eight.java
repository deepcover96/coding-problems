import java.util.*;

class Eight {
  public static void main(String[] args) {
    LinkedList llA = new LinkedList();
    LinkedList llB = new LinkedList();
    LinkedList llC = new LinkedList();
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node ten = new Node(10);
    Node twenty = new Node(20);
    Node thirty = new Node(30);

    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    Node g = new Node(7);


    llA.append(one);
    llA.append(two);
    llA.append(three);
    llA.append(four);
    four.setNext(two);

    llB.append(ten);
    llB.append(twenty);
    llB.append(thirty);
    thirty.setNext(ten);

    llC.append(a);
    llC.append(b);
    llC.append(c);
    llC.append(d);
    llC.append(e);
    llC.append(f);
    llC.append(g);
    g.setNext(c);

    Node result = loopDetection(llA);
    if(result == null)
      System.out.println("No loop Detected: Linked List A");

    Node result2 = loopDetection(llB);
    if(result2 == null)
      System.out.println("No loop Detected: Linked List B");
    Node resultA = loopDetection(llC);
    if(resultA == null)
      System.out.println("No loop Detected: Linked List C");


    Node result3 = loopDetectionRunner(llA);
    if(result3 == null)
      System.out.println("No loop Detected: Linked List A");

    Node result4 = loopDetectionRunner(llB);
    if(result4 == null)
      System.out.println("No loop Detected: Linked List B");

    Node resultB = loopDetectionRunner(llC);
    if(resultB == null)
      System.out.println("No loop Detected: Linked List C");
  }


  // Loop Detection: Given a circular Linked List, implement an algorithm that returns
  // the node at the beginning of the loop
  //  DEFINITION:
  //    Circular linked list: A (corrupt) linked list in which a nodes next pointer
  //        points to an earlier node, so as to make a loop in the linked list.
  // O (n) 
  public static Node loopDetection(LinkedList ll) {
    if (ll == null) return null;  // null check
    Node n = ll.getHead();
    HashSet<Node> set = new HashSet<Node>();

    while (n != null) {
      if (set.contains(n)) {
        System.out.println("Loop Detected: " + n.getVal());
        return n;
      } else {
        set.add(n);
        n = n.getNext();
      }
    }

    return null;
  }

  // Using FastRunner/Slowrunner approach
  public static Node loopDetectionRunner(LinkedList ll) {
    if (ll == null || ll.getHead() == null || ll.getHead().getNext() == null) return null;  // null check
    Node slow = ll.getHead();
    Node fast = ll.getHead();

    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      
      if (slow == fast) {
        System.out.println("Loop detected in runner.");
        break;
      }
    }

    slow = ll.getHead();

    while (slow != fast) {

      System.out.println("[" + slow.getVal() + "," + fast.getVal() + "]");
      slow = slow.getNext();
      fast = fast.getNext();
    }


    System.out.println("Loop in: " + fast.getVal());
    return fast;
  } 



}