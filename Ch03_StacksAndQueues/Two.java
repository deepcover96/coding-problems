import java.util.*;

class Two {
  public static void main(String[] args) {
    MinStack stack = new MinStack(10);

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

    stack.push(thirteen);
    stack.push(sixteen);
    stack.push(nine);
    stack.print();

    System.out.println(" Min: " + stack.min().getVal());

    stack.pop();
    stack.print();

    System.out.println(" Min: " + stack.min().getVal());

    stack.push(one);
    stack.print();

    System.out.println(" Min: " + stack.min().getVal());

    stack.pop();
    stack.pop();
    stack.print();

    System.out.println(" Min: " + stack.min().getVal());

  }
}

// Stack Min: Design a stack which, in addition to push and pop, has a function min()
// which returns the minimum element.  The push(), pop(), and min() methods should all
// operate in O(1) time.
class MinStack {
  private Item[] arr;
  private Item[] minArr;
  private int length;
  private int min;
  private int top;
  private int minTop;

  public MinStack(int length) {
    top = 0;
    minTop = 0;
    arr = new Item[length];
    minArr = new Item[length];
    this.length = length;
  }

  public boolean push(Item item) {
    if (top == length) return false;

    arr[top] = item;
    top += 1;

    if (minTop == 0) {
      minArr[minTop] = item;
      minTop += 1;
    } else if (item.getVal() < minArr[minTop - 1].getVal()) {
      minArr[minTop] = item;
      minTop += 1;
    }

    return true;
  }

  public Item pop() {
    Item item;
    if (top == 0) return null;

    top -= 1;
    item = arr[top];

    // pop the min stack if this is the min item
    if (minArr[minTop - 1] == item) {
      minTop -= 1;
    }

    return item;
  }

  public Item min() {
    if (minTop == 0)
      return null;
    else
      return minArr[minTop - 1];
  }

  public void print() {
    System.out.print("[ ");

    for (int i = 0; i < top; i++) {
      System.out.print(arr[i].getVal() + " ");
    }
    System.out.print("]");
  }
}
