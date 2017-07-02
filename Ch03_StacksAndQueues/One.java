import java.util.*;

class One {
  public static void main(String[] args) {
    TripleStack stack = new TripleStack();
    stack.print();

    Item one = new Item(1);
    Item two = new Item(2);
    Item three = new Item(3);
    Item four = new Item(4);
    Item five = new Item(5);
    Item six = new Item(6);
    Item seven = new Item(7);
    Item eight = new Item(8);
    Item nine = new Item(9);
    Item ten = new Item(10);
    Item eleven = new Item(11);
    Item twelve = new Item(12);
    Item thirteen = new Item(13);
    Item fourteen = new Item(14);
    Item fifteen = new Item(15);
    Item sixteen = new Item(16);

    stack.pushOne(one);
    stack.pushOne(two);
    stack.pushOne(three);
    stack.pushOne(four);
    stack.pushOne(five);

    stack.pushTwo(six);

    stack.pushThree(seven);


    stack.pushOne(six);
    stack.pushOne(seven);
    stack.pushOne(eight);
    stack.pushOne(nine);
    stack.pushOne(ten);
    stack.pushOne(eleven);
    stack.print();

    Item ten1 = stack.popOne();
    stack.pushTwo(ten1);

    Item seven1 = stack.popThree();
    stack.pushTwo(seven1);

    Item nothing = stack.popThree();
    stack.pushTwo(nothing);

    stack.pushThree(eleven);
    stack.pushOne(twelve);

    stack.print();

  }


}

// Three in One: Describe how you can use a single array to implement 3 stacks.
// We create a fixed-seze array containing 3 fixed stacks.
// A modification to this would to make the stacks dynamic, either by growing
// each stack within the limits of the array, or an even more advanced class would
// allow the array to grow as well.  
class TripleStack {
  private int stackOneBottom;
  private int stackOneTop;
  private int stackTwoBottom;
  private int stackTwoTop;
  private int stackThreeBottom;
  private int stackThreeTop;
  private int stackSize;

  private Item[] arr;

  public TripleStack() {
    stackSize = 30;
    arr = new Item[stackSize];

    stackOneBottom = 0;
    stackOneTop = 0;

    stackTwoBottom = 10;
    stackTwoTop = 10;

    stackThreeBottom = 20;
    stackThreeTop = 20;
  }

  public Item popOne() {
    Item item = pop (stackOneBottom, stackOneTop);
    if (item != null)
      stackOneTop -= 1;

    return item;
  }

  public Item popTwo() {
    Item item = pop (stackTwoBottom, stackTwoTop);
    if (item != null)
      stackTwoTop -= 1;

    return item;

  }

  public Item popThree() {
    Item item = pop (stackThreeBottom, stackThreeTop);
    if (item != null)
      stackThreeTop -= 1;

    return item;
  }

  public boolean pushOne(Item item) {
    boolean success = push (stackOneTop, stackTwoBottom, item);
    if (success)
      stackOneTop += 1;

    return success;
  }

  public boolean pushTwo(Item item) {
    boolean success = push (stackTwoTop, stackThreeBottom, item);
    if (success)
      stackTwoTop += 1;

    return success;
  }

  public boolean pushThree(Item item) {
    boolean success = push (stackThreeTop, arr.length, item);
    if (success)
      stackThreeTop += 1;

    return success;
  }

  private Item pop (int bottom, int top) {
    Item item = null;
    if (top != bottom) {
      top -= 1;
      item = arr[top];
    }

    return item;
  }

  private boolean push (int top, int limit, Item item) {
    if (item == null) return false;

    boolean result = false;
    if (top != limit) {
      arr[top] = item;
      result = true;
    }

    return result;
  }

  public void print() {
    System.out.print("[ ");

    for (int i = stackOneBottom; i < stackOneTop; i++) {
      System.out.print(arr[i].getVal() + " ");
    }
    System.out.print("][ ");


    for (int i = stackTwoBottom; i < stackTwoTop; i++) {
      System.out.print(arr[i].getVal() + " ");
    }
    System.out.print("][ ");


    for (int i = stackThreeBottom; i < stackThreeTop; i++) {
      System.out.print(arr[i].getVal() + " ");
    }
    System.out.println("]");
  }
}

class Item {
  int val;

  public Item(int val) {
    this.val = val;
  }

  public int getVal() { return val; }
}