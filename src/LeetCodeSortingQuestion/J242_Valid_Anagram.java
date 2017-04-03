package LeetCodeSortingQuestion;

public class J242_Valid_Anagram {

	public static void main(String[] args) {
		System.out.println(Solution("dabc", "cbadb"));
	}
	
	public static boolean Solution(String inputStr, String outputStr) {
		boolean result = true;
		int[] chContainer = new int[128];
		for (char c:inputStr.toCharArray()) {
			chContainer[c]++;
		}
		for (char c:outputStr.toCharArray()) {
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
