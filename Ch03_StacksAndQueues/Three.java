import java.util.*;

class Three {
  public static void main(String[] args) {
    SetOfStacks stack = new SetOfStacks(4);

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
    stack.push(one);

    stack.push(two);
    stack.push(three);
    stack.push(four);
    stack.push(five);

    stack.push(six);

    stack.print();

    stack.pop();
    stack.pop();

    stack.print();

    stack.push(five);
    
    stack.push(six);

    stack.print();

    stack.popAt(1);

    stack.print();

    stack.popAt(1);
    stack.popAt(1);
    stack.popAt(1);

    stack.print();

    stack.popAt(1);

    stack.print();

    stack.push(ten);
    stack.print();

  }
}

// Stack of Plates: Imagin a (literal) stack of plates.  If the stack gets too high,
// it might topple.  Therefore, in real life, we would likely start a new stack when
// the previous stack exceeeds some threshold.  Implement a data structure, SetOfStacks
// that mimics this.  Set of stacks should be composed of several stacks and should
// create a new stack once the previous one exceeds capacity.  SetOfStacks.push() and
// SetOfStacks.pop() should behave identically to a single stack (that is, pop() should
// return the same values as it would if there were just a single stack). 
// Follow Up: Implement a function popAt(int index) which performs a pop operation on a
// specific sub-stack.
class SetOfStacks {
  private MinStack[] subStacks;
  private int threshold;
  private int maxStacks;
  private int index;

  // We will just use MinStack from the previous example as our sub-stack structure 
  public SetOfStacks(int threshold) {
    this.threshold = threshold;
    maxStacks = 4;
    subStacks = new MinStack[maxStacks];
    index = 0;
    subStacks[index] = new MinStack(threshold);
  }

  public boolean push(Item item) {
    if (item == null) return false;
    if (subStacks[index].push(item)) {
      return true;
    } else {
      index += 1;
      subStacks[index] = new MinStack(threshold);
      return push(item);
    }
  }

  public Item pop() {
    Item item = subStacks[index].pop();
    if (item != null) {
      return item;
    } else {
      if (index == 0) return null;
      index -= 1;
      return pop();
    }
  }

  // I don't worry about stacks not being at full capacity,
  // or empty for that matter.  Using a list for the sub-stacks
  // would be better in practice, as it would be easier to get
  // rid of empty stacks.
  public Item popAt(int stackIndex) {
    if (stackIndex < 0 || stackIndex > index) return null;

    Item item = subStacks[stackIndex].pop();
    if (item != null) {
      return item;
    } else {
      if (stackIndex == 0) return null;
      return popAt(stackIndex - 1);
    }
  }

  public void print() {
    for (int i = index; i >= 0; i--) {
      subStacks[i].print();
      System.out.println();
    }
    System.out.println();
  }
}
