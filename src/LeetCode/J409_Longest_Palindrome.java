package LeetCode;

public class J409_Longest_Palindrome {

	public static void main(String[] args) {
		String s = "aabbccd";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		int[] array = new int[256];
		for (char ch : s.toCharArray()) {
			array[ch]++;
		}
		int midValue = 0;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			//check if value contains multiple 2
			if (array[i] == 1) {
				midValue = 1;
			} else if (array[i] >= 2) {
				if (array[i] % 2 == 1) {
					midValue = 1;
				}
				int tem = array[i] / 2;
				int v = tem * 2;
				count = count + v;
			}
		}
		count = count + midValue;
		return count;
	}

}
