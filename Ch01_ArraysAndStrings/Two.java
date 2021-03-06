import java.util.*;  


class Two {
	public static void main(String[] args) {
		
		String s1 = "QWERTYUIOP";
		String s2 = "POIUYTREWQ";
		String s3 = "QWERTYUIOO";
		String s4 = "foo";

		char[] string1 = s1.toCharArray();
		char[] string2 = s2.toCharArray();
		char[] string3 = s3.toCharArray();
		char[] string4 = s4.toCharArray();

		if (isPermutation(string1, string2))
			System.out.println(s1 + " is a permutation of. " + s2 + " Great!");
		else
			System.out.println(s1 + " <-> " + s2  + " ERROR");

		if (!isPermutation(string1, string3))
			System.out.println(s1 + " is NOT a permutation of. " + s2 + " Great!");
		else
			System.out.println(s1 + " <-> " + s3  + " ERROR. Should nor be permutation");

		if (!isPermutation(string2, string4))
			System.out.println(s2 + " is NOT a permutation of. " + s4 + " Great!");
		else
			System.out.println(s2 + " <-> " + s4  + " ERROR. Should nor be permutation");




		if (isPermutation2(s1, s2))
			System.out.println(s1 + " is a permutation of. " + s2 + " Great!");
		else
			System.out.println(s1 + " <-> " + s2  + " ERROR");

		if (!isPermutation2(s1, s3))
			System.out.println(s1 + " is NOT a permutation of. " + s2 + " Great!");
		else
			System.out.println(s1 + " <-> " + s3  + " ERROR. Should nor be permutation");

		if (!isPermutation2(s2, s4))
			System.out.println(s2 + " is NOT a permutation of. " + s4 + " Great!");
		else
			System.out.println(s2 + " <-> " + s4  + " ERROR. Should nor be permutation");
	}


	// Given two strings, write a method to decide if one is a permutation of the other
	// Complexity:  O(n)
	public static boolean isPermutation(char[] str1, char[] str2) {
		// null checking
		if (str1 == null || str2 == null) return false;
		// lengths are not equal, then cannot be a permutation
		if (str1.length != str2.length) return false;
		// use hash table to record character count
		Map<Character, Integer> hashMap1 = new HashMap<>();
		Map<Character, Integer> hashMap2 = new HashMap<>();

		// create two maps, ensure key size is equal, then compare key-values
		hashMap1 = getCharMap(str1);
		hashMap2 = getCharMap(str2);

		// ensure key size is equal
		if (hashMap1.size() != hashMap2.size())
			return false;

		// then compare key-values
		for (Character c : hashMap1.keySet()) {
			if (hashMap2.containsKey(c)) {
				if (hashMap1.get(c) != hashMap2.get(c)) {
					return false;
				}
			} else {
				return false;
			}
		} 

		return true;
	}

	private static Map<Character,Integer> getCharMap(char[] arr) {
		Map<Character, Integer> hashMap = new HashMap<>();

		for (int i=0; i<arr.length; i++) {
			char c = arr[i];
			Integer count = 0;
			if (hashMap.containsKey(c)) {
				count = hashMap.get(c);
			} 

			count += 1;
			hashMap.put(c, count);
		} 

		return hashMap;
	}

	
	// OK, let's simplify this.  We will populate our map with the first string
	// and then decrement using the values of the second string.  We should not go 
	// below 0.
	public static boolean isPermutation2(String str1, String str2) {
		// make sure the strings are the same lengths
		if (str1.length() != str2.length()) return false;

		// populate the array to be a map of char counts
		int[] countMap = new int[128];
		for (int i =0; i < str1.length(); i++) {
			int index = (int) str1.charAt(i);
			countMap[index] += 1;
		}

		// using the second array, decrement values from the map
		// if we get below 0, we know that we are not a permutation
		for (int i =0; i < str2.length(); i++) {
			int index = (int) str2.charAt(i);
			countMap[index] -= 1;

			if (countMap[index] < 0)
				return false;
		}

		return true;
	}
}