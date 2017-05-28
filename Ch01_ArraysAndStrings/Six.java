import java.util.*;

class Six {
	public static void main(String[] args) {
    String str1 = "aabcccccaaa";
    String str2 = "abcdefg";
    String str3 = "aaaaaaaaaaaaaaattttttttttttttt"; // 15 of each

    System.out.println("For: " + str1 + " :  -> " + compress(str1.toCharArray()));
    System.out.println("For: " + str2 + " :  -> " + compress(str2.toCharArray()));
    System.out.println("For: " + str3 + " :  -> " + compress(str3.toCharArray()));
    
      
	}

	// String Compression.  Implement a method to perform basic string compression using the counts of
  // repeated characters.  For example, the string aabcccccaaa would become a2b1c5a3.  If the "compressed"
  // string would not become smaller than the original string, your method should return the original
  // string.  You can assume the string has only uppercase and lowercase letters (a-z).
  // O (n) n being the size of the 
  public static String compress(char[] arr) {
    if (arr.length <= 2) return new String(arr);

    int index = 0;
    int count = 0;
    char[] compressed = new char[arr.length];

    for (int i = 0; i < arr.length; i++) {
      // if character changed or if we are at the end
      if (i == arr.length - 1 || arr[i] != arr[i + 1]) {

        // append the new character
        compressed[index] = arr[i];
        index += 1;
        count += 1;

        // check if we are going to grow larger than original string
        // if compressed array is the same or larger than original, return uncompressed
        String countStr = Integer.toString(count);
        if (countStr.length() + index + 1 >= arr.length)
          return new String(arr);

        // append the previous count 
        addCharCount(compressed, countStr, index);
        index += countStr.length(); 

        // reset count
        count = 0;
      } else {
        count += 1;
      }
    }
    return new String(compressed);
  }

  // add the character count and return the number of characters used (i.e. 33 returns uses two characters)
  private static void addCharCount(char[] compressed, String countStr, int index) {
    for (int i = 0; i < countStr.length(); i++) {
        compressed[index] = countStr.charAt(i);
        index += 1;
    }
  }

}
