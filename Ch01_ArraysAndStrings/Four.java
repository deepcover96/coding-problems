import java.util.*;

class Four {
	public static void main(String[] args) {
    String str = "Mr John Smith";
    String str1 = "Tact Coa";
    String str2 = "aaaabbbb";
    String str3 = "aaaavbbbb";

    if (isPalindrone(str.toCharArray()))
      System.out.println(str);
    if (isPalindrone(str1.toCharArray()))
      System.out.println(str1);
    if (isPalindrone(str2.toCharArray()))
      System.out.println(str2);
    if (isPalindrone(str3.toCharArray()))
      System.out.println(str3);
	}

	// Given a string, write a function to check if it is a permutation of a palindrone.
  // A palindrone is a word or phrase that is the same forward or backwards.  A
  // permutation is an arrangement of letters.  The palindrone does not need to be limited
  // to just dictionary words.
  // Example:
  //    Input: Tact Coa
  //    Output: True (Taco Cat, atco cta) 
  // Takes O(n) time
	public static boolean isPalindrone(char[] arr) {
    // map charaters to get specific char count

    Map<Character, Integer> charMap = new HashMap<>();
    int length = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != ' ') {
        Character ch = Character.toLowerCase(arr[i]);
        int d = charMap.getOrDefault(ch, 0);
        charMap.put(ch, d + 1);
        length += 1;
      }
    }

    // allow 1 odd character for odd string lingth
    int oddCount = 0;  // only 1 odd char allowed if odd number of chars in string
    if (length % 2 == 1)
      oddCount = -1;

    // check the count of each char and update the number of odd chars
    for (Integer count : charMap.values()) {
      if (count % 2 == 1)
        oddCount += 1;
      if (oddCount > 0)
        return false;
    }

    return true;
  }
}
