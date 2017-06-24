import java.util.*;

class Five {
  public static void main(String[] args) {
    LinkedList llA = new LinkedList();
    LinkedList llB = new LinkedList();
    Node one = new Node(1);
    Node one1 = new Node(1);
    Node two = new Node(2);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);
    Node nine = new Node(9);


    llA.append(seven);
    llA.append(one);
    llA.append(six);
    llA.append(one1);

    llB.append(five);
    llB.append(nine);
    llB.append(two);

    LinkedList ll = sumLists(llA, llB);
    LinkedList ll2 = sumListsRecursive(llA, llB);


    llA.print();
    System.out.println("+");
    llB.print();
    System.out.println("-------");
    ll.print();

    System.out.println();
    System.out.println();

    llA.print();
    System.out.println("+");
    llB.print();
    System.out.println("-------");
    ll2.print();

    System.out.println();
    System.out.println();


    LinkedList llX = new LinkedList();
    LinkedList llY = new LinkedList();
    Node oneA = new Node(1);
    Node one1A = new Node(1);
    Node twoA = new Node(2);
    Node fiveA = new Node(5);
    Node sixA = new Node(6);
    Node sevenA = new Node(7);
    Node nineA = new Node(9);

    llX.append(one1A);
    llX.append(sixA);
    llX.append(oneA);
    llX.append(sevenA);

    llY.append(twoA);
    llY.append(nineA);
    llY.append(fiveA);


    LinkedList llZ = sumLists2(llX, llY);


    llX.print();
    System.out.println("+");
    llY.print();
    System.out.println("-------");
    llZ.print();
  }



  // Partition: You have two numbers represented by a linked list, where each node contains
  // a single digit.  The digits are stored in reverse order, such that the 1's digit is at
  // the head of the list.  Write a function that adds the two numbers and returns the sum
  // as a linked list.
  // Example:
  //   Input:  (7 -> 1 -> 6) + (5 -> 9 -> 2).  That is, 617 +  295.
  //   Output: 2 -> 1 -> 9.  That is, 912.
  // O (n) with n being the larger of the two lists
  public static LinkedList sumLists(LinkedList llA, LinkedList llB) {
    if (llA == null || llB == null) return null;
    LinkedList ll = new LinkedList();
    Node aNext = llA.getHead();
    Node bNext = llB.getHead();
    int carry = 0;

    // until both lists are at the tail
    while (aNext != null || bNext != null) {
      int a = 0;
      int b = 0;

      if (aNext != null) {  // if not at the tail, get val and increment
        a = aNext.getVal();
        aNext = aNext.getNext();
      }
      if (bNext != null) {  // if not at the tail, get val and increment
        b = bNext.getVal();
        bNext = bNext.getNext();
      }
      int x = a + b + carry;  // add values as well as carryover
      int digit = x % 10;     // get the digit in the ones place 

      ll.append(new Node(digit));  // add the node 
      carry = (x - digit) / 10;    // cary over the digit in the 10's place
    }

    if (carry > 0)
      ll.append(new Node(carry));  // don't forget about any carried digit

    return ll;
  }

  public static LinkedList sumListsRecursive(LinkedList llA, LinkedList llB) {
    if (llA == null || llB == null) return null;
    LinkedList ll = new LinkedList();
    Node head = addNodes(llA.getHead(), llB.getHead(), 0);
    ll.append(head);
    return ll;
  }

  private static Node addNodes(Node nA, Node nB, int carryover) {
    if (nA == null && nB == null && carryover == 0) return null;

    int sum = carryover;   // working sum
    int digit = 0;  // digit for this node
    int carry = 0;  // carry over to next node (carry the 1)
    Node nextA = null;  // pointer for next node on list A
    Node nextB = null;  // pointer for next node on list B
    Node n = null;     // current node
    Node next = null;  // next node

    // account for uneven lists
    if (nA != null) {
      sum += nA.getVal();
      nextA = nA.getNext();
    }
    if (nB != null) {
      sum += nB.getVal();
      nextB = nB.getNext();
    }

    // calculate digit for this node and the value to carry forward
    digit = sum % 10;
    carry = (sum - digit) / 10;

    // get next node and append it to current node
    next = addNodes(nextA, nextB, carry);
    n = new Node(digit);
    n.setNext(next);
    return n;
  }

  // Follow-UP: Suppose the digits are stored in forward order. Repeat the above problem.
  // Example:
  //   Input:  (6 -> 1 -> 7) + (2 -> 9 -> 5).  That is, 617 +  295.
  //   Output: 9 -> 1 -> 2.  That is, 912.
  public static LinkedList sumLists2(LinkedList llA, LinkedList llB) {
    if (llA == null || llB == null) return null;
    LinkedList ll = new LinkedList();
    CarryPair pair = null;
    int lengthA = llA.length();
    int lengthB = llB.length();

    // if one list is larger than the other, pass the larger in first
    if (lengthA > lengthB)
      pair = addNodes2(llA.getHead(), llB.getHead(), lengthA - lengthB);
    else
      pair = addNodes2(llB.getHead(), llA.getHead(), lengthB - lengthA);

    if (pair.getCarry() > 0) {
      Node n = new Node(pair.getCarry());
      n.setNext(pair.getNode());
      ll.append(n);
    } else {
      ll.append(pair.getNode());
    }
    return ll;
  }

  private static CarryPair addNodes2(Node nA, Node nB, int padding) {
    if (nA == null && nB == null) return new CarryPair(null, 0);

    int valA = nA.getVal();
    int valB = nB.getVal();
    Node nextA = nA.getNext();
    Node nextB = nB.getNext();
    int sum = 0;
    int digit = 0;
    int carry = 0;
    Node n = null;
    CarryPair pair = null;


    // since nodes are in order from left to right, 
    // we account for padding to line up digits
    if (padding > 0) {
      valB = 0;
      nextB = nB;
      padding -= 1;
    }

    sum = valA + valB;
    pair = addNodes2(nextA, nextB, padding);
    sum += pair.getCarry();
    digit = sum % 10;
    carry = (sum - digit) / 10;

    n = new Node(digit);
    n.setNext(pair.getNode());

    return new CarryPair(n, carry);
  }

}

class CarryPair {
  int carry = 0;
  Node node = null;

  public CarryPair(Node node, int carry) {
    this.node = node;
    this.carry = carry;
  }

  public int getCarry() { return carry; }
  public Node getNode() { return node; }
}
