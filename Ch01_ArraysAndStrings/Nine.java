import java.util.*;

class Nine {
	public static void main(String[] args) {
    String w1 = "waterbottle";
    String w2 = "erbottlewat";
    boolean result = isRotation(w1, w2);
    System.out.println("Is " + w2 + " a rotation of " + w1 + "? " + result);

    String w3 = "bottle";
    result = isRotation(w1, w3);
    System.out.println("Is " + w3 + " a rotation of " + w1 + "? " + result);
	}

	// String Rotation: Assume you have a method 'isSubstring' which checks if one word is
  // a substring of another. Given two strings, s1 and s2, write code to check if s2 is
  // a rotation of s1 using only one call to 'isSubstring'
  // Example: "waterbottle" is a rotation of "erbottlewat"
  public static boolean isRotation(String str1, String str2) {
    // they must be the same length in order to be a rotation
    if (str1.length() != str2.length() || str1.length() == 0) return false;

    // append str2 onto itself to get a double word
    // erbottlewaterbottlewat
    // waterbottle will be inside if it is a rotation
    // erbottle_waterbottle_wat
    String str2Double = str2 + str2;
    if (str2Double.contains(str1)) // isSubstring
      return true;
    else
      return false;
  }
}
