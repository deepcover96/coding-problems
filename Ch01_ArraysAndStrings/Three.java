import java.util.*;  


class Three {
	public static void main(String[] args) {
    String str = "Mr John Smith                          ";
    char[] arr = str.toCharArray();
    URLify(arr, 13);
	}

	// Write a method to replace all spaces in a string with '%20'.
	// You may assume that the string has sufficient space at the 
	// end to hold the additional characters, and that you are given
	// the "true" length of the string.  Use a character array.
	// Example:
	//    Input:  "Mr John Smith    ", 13
	//    Output: "Mr%20John%20Smith"
	public static void URLify(char[] arr, int length) {
    if (length <= 0) return;
    if (arr == null) return;

    // assume length of final string to be worst case: length * 3
    int writeIndex = (length * 3) - 1;	 
    int newLength = writeIndex;

    if(writeIndex >= arr.length) return;

    // read array from back to front, copying characters to the end of the array.
    for (int i = length - 1; i >= 0; i--) {
      if (arr[i] == ' ')
        // when encountering a space, put the characters % 2 0 in it's place
        writeIndex = addEncodedSpace(arr, writeIndex);
      else
        // copy to back
        arr[writeIndex] = arr[i];

      writeIndex -=1;
    }

    // when complete, copy the final string back to the front of the array
    newLength -= writeIndex;
    moveStringToFront(arr, writeIndex + 1, newLength);

    System.out.println(new String(arr));
	}

  // add space (encoded) and return new write index (last written location)
  private static int addEncodedSpace(char[] arr, int index) {
    arr[index] = '0';
    arr[index - 1] = '2';
    arr[index - 2] = '%';

    return index - 2;
  }

  // move the string to front of array
  private static void moveStringToFront(char[] arr, int startIndex, int length) {
    int index = 0;    
    for (int i = startIndex; i < length + startIndex; i++) {
      arr[index] = arr[i];
      index += 1;
    }

    // terminate
    if (index < arr.length)
      arr[index] = '/';
  }
}
