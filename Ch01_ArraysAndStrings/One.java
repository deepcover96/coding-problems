import java.util.*;  


class One {
	public static void main(String[] args) {
		String u = "ASDFGHJKL";
		String n = "ASDFGHA";
		char[] unique = u.toCharArray();
		char[] notUnique = n.toCharArray();

		if (isUnique(unique))
			System.out.println(u + " is unique. Great!");
		else
			System.out.println(u + " ERROR");

		if (isUnique2(unique))
			System.out.println(u + " is unique. Groovy!");
		else
			System.out.println(u + " ERROR");

		if (!isUnique(notUnique))
			System.out.println(n + " is not unique. Great!");
		else
			System.out.println(n + " ERROR");

		if (!isUnique2(notUnique))
			System.out.println(n + " is not unique. Groovy!");
		else
			System.out.println(n + " ERROR");

	}


	// Implement an algorithm to determine if a string has all unique characters.
	public static boolean isUnique(char[] str) {
		Map<Character, Integer> hashMap = new HashMap<>();
		if (str == null) return false;

		// assuming ASCII, so if char count is more than 128, return false
		if (str.length > 128)
			return false;

		for (int i=0; i<str.length; i++) {
			if (hashMap.containsKey(str[i])) {
				return false;
			} else {
				hashMap.put(str[i], 1);
			}
		}
		return true;
	}

	// What if you cannot use additional data structures?
	// Complexity: O(n) since we must traverse the array of characters only once
	public static boolean isUnique2(char[] str) {
		// we implement our own hash table
		int[] map = new int[128];
		if (str == null) return false;

		// assuming ASCII, so if char count is more than 128, return false
		if (str.length > 128)
			return false;

		for (int i=0; i<str.length; i++) {
			int asciiVal = (int) str[i];  // convert to ascii value
			if (map[asciiVal] != 0) {
				return false;
			} else {
				map[asciiVal] = 1;
			}
		}
		return true;
	}
}