package LeetCode;

public class J290_Word_Pattern {

	public static void main(String[] args) {
		String pattern = "abcdd";
		String word = "my logic is correct correct";
		System.out.println(solution(pattern,word));
	}
	
	public static boolean solution(String pattern, String word) {
		String[] words = word.split(" ");
		char[] ch = pattern.toCharArray();
		if (words.length != ch.length) return false;
		boolean result = true;
		
		for (int i = 0; i < ch.length; i++) {
			for (int j = i + 1; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					if (!words[i].equals(words[j])){
						result = false;
						return result;
					} 
				} else {
					if (words[i].equals(words[j])) {
						result = false;
						return result;
					}
				}
			}
		}
		return result;
	}

}

