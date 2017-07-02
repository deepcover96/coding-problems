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
class SetOfStacks {
  private MinStack[] subStacks;
  private int threshold;
  private int maxStacks;
  private int index;

  // We will just use MinStack from the previous example as our sub-stack structure 
  public SetOfStacks(int threshold) {
    this.threshold = threshold;
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

  public void print() {
    for (int i = index - 1; i >= 0; i--) {
      subStacks[i].print();
    }
  }
}
