import java.util.*;

class Five {
	public static void main(String[] args) {
    String pale = "pale";
    String pales = "pales";
    String str1 = "ple";
    String str2 = "pale";
    String str3 = "bale";
    String str4 = "bake";

    if (canEditInOne(pale.toCharArray(), str1.toCharArray()))
      System.out.println(str1);
    
    if (canEditInOne(pales.toCharArray(), str2.toCharArray()))
      System.out.println(str2);
    
    if (canEditInOne(pale.toCharArray(), str3.toCharArray()))
      System.out.println(str3);
    if (canEditInOne(pale.toCharArray(), str4.toCharArray()))
      System.out.println(str4);
      
	}

	// There are three types of edits that can be performed on strings: insert a character,
  // remove a character, ore replace a character.  Given two strings, write a function to
  // check if they are one edit away.
  // Example:
  //    pale, ple -> true
  //    pales, pale -> true
  //    pale, bale -> true
  //    pale, bake -> false
	public static boolean canEditInOne(char[] str1, char[] str2) {
    int diff = str2.length - str1.length;
    boolean sameLength = str1.length == str2.length;

    // must be within 1 character in length
    if (diff < -1 || diff > 1)
      return false;

    // compare characters
    // We will make str1 always the larger one
    if (str1.length > str2.length)
      return compareStrings(str1, str2, sameLength);
    else
      return compareStrings(str2, str1, sameLength);
  }


  // if str_1 is smaller, str_2 is allowed 1 remove operation
  // if str_1 is larger, str_2 is allowed 1 add operation
  // if same length, str_2 is allowed 1 replace operation 
  // We will make str1 always the larger one
  private static boolean compareStrings(char[] str1, char[] str2, boolean sameLength) {
    boolean corrected = false;
    int j = 0;

    // iterate using the size of the smaller string
    for (int i = 0; i < str2.length; i++) {
      if (str1[i] != str2[j]) {
        if (corrected)
          return false;  // this is the second correction, so false

        // these string are the same length, it is assumed to be a replace
        // if not, it is assumed to be an insert, remember: we are iterating on the larger string
        if (sameLength)
          j += 1;

        // mark as corrected once already
        corrected = true;
      } else {
        j += 1;
      }
    }

    // deal with last character of each string, only an issue if we have a correction already
    if (!sameLength && corrected) {
      if (str1[str1.length - 1] != str2[str2.length - 1]) {
        return false;
      }
    }

    return true;
  }
}
