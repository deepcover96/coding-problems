import java.util.*;

class Seven {
  public static void main(String[] args) {
    LinkedList llA = new LinkedList();
    LinkedList llB = new LinkedList();
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node ten = new Node(10);
    Node twenty = new Node(20);
    Node thirty = new Node(30);

    llA.append(one);
    llA.append(two);
    llA.append(three);
    llA.append(four);
    llA.print();

    llB.append(ten);
    llB.append(twenty);
    llB.append(thirty);
    llB.append(three);

    llB.print();

    boolean result = isIntersecting(llA, llB);
    System.out.println("Intersecting? " + result);

  }



  // Intersection: Given two singly-linked lists, determine if the two lists intersect.
  // Return the intersecting node.  Note that the intersection is based on reference, not
  // value.  that is, if the kth node of the first linked list is the exact same node 
  // (by reference) as the jth node of the second linked list, then they are intersecting.
  // O (n)
  public static boolean isIntersecting(LinkedList llA, LinkedList llB) {
    if (llA == null || llB == null) return false;  // null check
    Node a = llA.getHead();
    Node b = llB.getHead();
    Node longNode = null;
    int difference = 0;

    // find the larger of the two lists
    if (llA.getLength() < llB.getLength()) {
      longNode = b;
      difference = llB.getLength() - llA.getLength();
    } else {
      longNode = a;
      difference = llA.getLength() - llB.getLength();
    }

    // Increment the larger list so that they can now start at the same place from the end.
    // Remember, they would have the same tail.
    for (int i = 0; i < difference; i++)
      longNode = longNode.getNext();
    
    if (llA.getLength() < llB.getLength())
      b = longNode;
    else
      a = longNode;

    // iterate both lists together until we get a match
    while (a != null) {
      if (a == b) {
        System.out.println("Intersection at: " + b.getVal());
        return true;
      }
      a = a.getNext();
      b = b.getNext();
    }

    return false;
  }

  // O (n + m), we do better up above
  public static boolean isIntersectingOld(LinkedList llA, LinkedList llB) {
    if (llA == null || llB == null) return false;  // null check
    Node a = llA.getHead();
    Node b = llB.getHead();
    HashSet<Node> set = new HashSet<Node>();

    while (a != null) {
      set.add(a);
      a = a.getNext();
    }

    while (b != null) {
      if (set.contains(b)) {
        System.out.println("Intersection at: " + b.getVal());
        return true;
      }
      b = b.getNext();
    }

    return false;
  }



}