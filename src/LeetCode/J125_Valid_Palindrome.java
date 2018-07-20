package LeetCode;

public class J125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if ("".equals(s)) return true;
        String str = convertToPureStr(s);
        int end;
        if (str.length() % 2 == 0) {
            end = str.length() / 2 - 1;
        } else {
            end = str.length() / 2;
        }

        int first = 0;
        int last = str.length() - 1;
        while (first <= end) {
            if (!(str.charAt(first) == str.charAt(last))) {
                return false;
            }
            first++;
            last--;
        }


        return true;
    }

    public String convertToPureStr(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (String.valueOf(arr[i]).matches("[0-9a-zA-Z]")) {
                sb.append(String.valueOf(arr[i]).toLowerCase());
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome1(String s) {
        if ("".equals(s)) return true;
        String pureStr = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        String rev = new StringBuffer(pureStr).reverse().toString();
        return pureStr.equals(rev);

    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        System.out.println(new J125_Valid_Palindrome().isPalindrome(s));
    }
}
