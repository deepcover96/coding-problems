import java.util.*;

class Sort {
  public static void main(String[] args) {
    long start = 0;
    long finish = 0;
    int[] arr = new int[]{5,3,1,6,7,8,2,4,1,2,7};
    System.out.println(Arrays.toString(arr));
    
    // Bubble Sort
    System.out.println("--- Bubble Sort ---");
    start = System.nanoTime();
    bubbleSort(arr);
    finish = System.nanoTime();
    System.out.println(Arrays.toString(arr));
    System.out.println("   Time (ns): " + (finish - start));
  }

  public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length <= 1) return;
    boolean swap = true;
    int length = arr.length;

    // until there is no swapping, worst case O(n) complexity
    while (swap) {
      swap = false;

      for (int i = 1; i < length; i++) {
        // swap if right element is smaller than left
        if (arr[i] < arr[i - 1]) {
          int temp = arr[i];
          arr[i] = arr[i-1];
          arr[i-1] = temp;
          swap = true;
        }
      }
      length -= 1;  // element at the end is the largest, se we can shorten the search by 1
    }
  }
}
