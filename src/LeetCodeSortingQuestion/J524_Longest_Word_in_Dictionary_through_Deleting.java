package LeetCodeSortingQuestion;

import java.util.*;

public class J524_Longest_Word_in_Dictionary_through_Deleting {

	public static void main(String[] args) {
		String s = "abcdefg";
		List<String> l = new ArrayList<String>();
		l.add("bcd");
		l.add("mcd");
		l.add("adefg");
		System.out.println(findLongestWord(s,l));
	}
	
	public static String findLongestWord(String s, List<String> l) {
		//Need do the Lexicographic Order about List
		int[] arr = new int[128];
		boolean valid = true;
		int maxSize = -1;
		int index = -1;
		
		for (char c:s.toCharArray()) {
			arr[c]++;
		}
		for (int i = 0; i < l.size(); i++) {
			int[] cloneArr = arr.clone();
			String str = l.get(i);
			for (char c:str.toCharArray()) {
				cloneArr[c]--;
			}
			for (int val:cloneArr) {
				if (val < 0) {
					valid = false;
					break;
				}
			}
			if (l.get(i).length() > maxSize && valid == true) {
				maxSize = l.get(i).length();
				index = i;
			}
			valid = true;
		}
		if (index == -1) {
			return "";
		} else {
			return l.get(index);	
		}
	}

}
