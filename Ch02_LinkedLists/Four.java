import java.util.*;

class Four {
  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node five = new Node(5);
    Node five2 = new Node(5);
    Node eight = new Node(8);
    Node ten = new Node(10);

    ll.append(three);
    ll.append(five);
    ll.append(eight);
    ll.append(five2);
    ll.append(ten);
    ll.append(two);
    ll.append(one);
    ll.print();



    System.out.println("  partitioning on " + five.getVal());
    partition2(ll, five.getVal());
    ll.print();

    System.out.println(" --- ");

    LinkedList mm = new LinkedList();
    Node a = new Node(1);
    Node b = new Node(1);
    Node c = new Node(1);
    Node d = new Node(1);
    Node e = new Node(10);
    mm.append(a);
    mm.append(b);
    mm.append(c);
    mm.append(d);
    mm.print();

    System.out.println("  partitioning on " + five.getVal());
    partition(mm, five.getVal());
    mm.print();

    System.out.println(" --- ");
    mm.print();
    System.out.println("  partitioning on " + one.getVal());
    partition(mm, one.getVal());
    mm.print();

    System.out.println(" --- ");
    mm.append(e);
    mm.print();
    System.out.println("  partitioning on " + one.getVal());
    partition(mm, one.getVal());
    mm.print();

    System.out.println(" --- ");
    ll.print();
    System.out.println("  partitioning on " + five.getVal());
    partition(ll, five.getVal());
    ll.print();
    
    System.out.println(" --- alternate method ---");
    partition2(ll, five.getVal());
    ll.print();

    
    System.out.println(" --- ");
    ll.print();
    System.out.println("  partitioning on " + ten.getVal());
    partition(ll, ten.getVal());
    ll.print();

    System.out.println(" --- ");
    ll.print();
    System.out.println("  partitioning on " + three.getVal());
    partition(ll, three.getVal());
    ll.print();
    
  }



  // Partition: Wrtie code to partition a linked list around a value x, such that
  // all nodes less than x come before all nodes greater than or equal to x.  If x
  // is contained within the list, the values of x only need to be contained after
  // the elements less than x.  The partition element x can appear anywhere in the
  // right partition; it does not need to appear between the left and right partitions.
  // Example:
  //   Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 
  //      [ Partition = 5 ]
  //   Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
  // O (n)
  public static void partition(LinkedList ll, int partition) {
    if (ll == null) return;
    Node current = ll.getHead();
    Node previous = null;
    Node firstMovedNode = null;

    // until we wrap around to the first moved node or the end 
    while (current != firstMovedNode && current != null) {
      // if in partition, move to end
      if (current.getVal() >= partition) {
        // if moving it, set as limit
        if (firstMovedNode == null)
          firstMovedNode = current;
        // remove node and set current to next, previous doesn't change
        ll.removeNextNode(previous);
        Node next = current.getNext();
        current.setNext(null);
        ll.append(current);
        current = next;
      } else {
        // update previous and current
        previous = current;
        current = current.getNext();
      }
    }
  }

  // this one will use 2 lists and merge them
  // it will keep the partitions in the order that they were originally in
  public static void partition2(LinkedList ll, int partition) {
    if (ll == null) return;
    LinkedList partitionList = new LinkedList();
    Node n = ll.getHead();
    Node previous = null;
    int d = 0;

    // put partition elements in thier own list
    while (n != null) {
      if (n.getVal() >= partition) {
        partitionList.append(n);
        ll.removeNextNode(previous);
        Node next = n.getNext();
        n.setNext(null);
        n = next;
      } else {
        previous = n;
        n = n.getNext();
      }
    }

    Node p = partitionList.getHead();

    while (p != null) {
      ll.append(p);
      p = p.getNext();
    }
    
  }

}
