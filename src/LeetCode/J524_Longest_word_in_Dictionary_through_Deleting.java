package LeetCode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class J524_Longest_word_in_Dictionary_through_Deleting {
	
	public String findLongestWord(String s, List<String> d) {
		String max = "";
		for (int i = 0; i < d.size(); i++) {
			String subStr = d.get(i);
			if (isSubString(s, subStr)) {
				if (subStr.length() > max.length()) {
					max = subStr;
				} else if ((subStr.length() == max.length()) && subStr.compareTo(max) < 0) {
					max = subStr;
				}
			}
		}
		return max;
    }
	
	public boolean isSubString(String str, String subStr) {
		boolean result = true;
		int[] arr = new int[128];
		for (char i : str.toCharArray()) {
			arr[i]++;
		}
		for (char i : subStr.toCharArray()) {
			arr[i]--;
		}
		for (int i : arr) {
			if (i < 0) {
				result = false;
				break;
			}
		}
		return result;
	}
	
    @Test
    public void test() {
    	assertEquals("apple", new J524_Longest_word_in_Dictionary_through_Deleting().findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    	assertEquals("a", new J524_Longest_word_in_Dictionary_through_Deleting().findLongestWord("abpcplea", Arrays.asList("a","b","c")));
    	assertEquals("awefawfwaf", new J524_Longest_word_in_Dictionary_through_Deleting().findLongestWord("aewfafwafjlwajflwajflwafj", Arrays.asList("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf")));
    }
}
