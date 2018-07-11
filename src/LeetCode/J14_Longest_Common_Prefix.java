package LeetCode;

public class J14_Longest_Common_Prefix {
    public String commonPrefix(String[] strs) {
        if (strs.length == 0 || "".equals(strs[0])) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char firstChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1) {
                    return sb.toString();
                }
                char nextChar = strs[j].charAt(i);
                if (firstChar != nextChar) {
                    return sb.toString();
                }
            }
            sb.append(firstChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {};
        System.out.println(new J14_Longest_Common_Prefix().commonPrefix(strs));
    }
}
