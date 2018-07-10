package LeetCode;

//Roman to integer
//Nomarlly big -> small, if not, is subtraction
//I 1
//V 5
//X 10
//L 50
//C 100
//D 500
//M 1000

//III 3, IV 4, IX 9, MCMXCIV 1994
public class J13_Roman_To_Integer {
    public int RomanToInt(String s) {
        if ("".equals(s)) return 0;
        int res = 0;
        char[] arr = s.toCharArray();
        int j = 0;
        if (arr.length == 1) return transfer(arr[0]);
        for (int i = 1; i < arr.length;) {
            if (transfer(arr[j]) >= transfer(arr[i])) {
                res += transfer(arr[j]);
                i++;
                j++;
            } else {
                res += transfer(arr[i]) - transfer(arr[j]);
                i = i + 2;
                j = j + 2;
            }
        }
        //consider last value may not be calculated eg:MC
        if (arr.length >= 2 && transfer(arr[arr.length - 1]) <= transfer(arr[arr.length - 2])) {
            res += transfer(arr[arr.length - 1]);
        }
        return res;
    }

    public int transfer(char s) {
        if (s == 'I') {
            return 1;
        } else if (s == 'V') {
            return 5;
        } else if (s == 'X') {
            return 10;
        } else if (s == 'L') {
            return 50;
        } else if (s == 'C') {
            return 100;
        } else if (s == 'D') {
            return 500;
        } else if (s == 'M') {
            return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = new J13_Roman_To_Integer().RomanToInt("D");
        System.out.println(res);
        String test = "test";
        System.out.println(test.charAt(1));

    }
}
