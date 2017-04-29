package LeetCode;

public class J242_Valid_Anagram {

	public static void main(String[] args) {
		String s = "apple";
		String t = "ppale";
		System.out.println(isAnagram(s,t));
	}
	
	public static boolean isAnagram(String s, String t) {
        boolean result = true;
		int[] chContainer = new int[128];
		for (char c:s.toCharArray()) {
			chContainer[c]++;
		}
		for (char c:t.toCharArray()) {
			chContainer[c]--;
		}
		for (int i:chContainer) {
			if (i != 0) {
				result = false;
			} 
		}
		return result;
   
    }

}
