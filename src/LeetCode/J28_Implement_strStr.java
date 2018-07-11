package LeetCode;

public class J28_Implement_strStr {
    public int solution(String haystack, String niddle) {
        if ("".equals(niddle)) return 0;
        if (niddle.length() > haystack.length()) return -1;

        char ch = niddle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == ch) {
                if (haystack.length() - i < niddle.length()) return -1;
                String subHay = haystack.substring(i, i + niddle.length());
                if (subHay.equals(niddle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new J28_Implement_strStr().solution("abcdcde", "cde"));
    }
}
