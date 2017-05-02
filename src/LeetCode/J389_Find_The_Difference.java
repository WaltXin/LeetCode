package LeetCode;
/**
 * 77.44%
 * */

public class J389_Find_The_Difference {

	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "abcdef";
		char res = solution2(s1,s2);
		System.out.println(res);
	}
	
	public static char solution1(String s1, String s2) {
		//compare one by one O(n) loop once, only accept if the s2 is only one character diff with s1
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) return s2.charAt(i);
		}
		return s2.charAt(s2.length() - 1);
	}
	
	public static char solution2(String s1, String s2) {
		//char array O(n) 3n 
		int[] array = new int[128];
		for (char ch : s2.toCharArray()) {
			array[ch]++;
		}
		for (char ch:s1.toCharArray()) {
			array[ch]--;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0){
				return (char)i;
			}
		}
		return '!';
	}

}