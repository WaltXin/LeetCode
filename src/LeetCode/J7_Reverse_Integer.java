package LeetCode;


//reverse integer
//[-2^31, 2^31 - 1]
//-123 -> -321
//123 -> 321
//if overflow return 0
public class J7_Reverse_Integer {
    public int solution(int a) {
        if (a >= -9 && a <= 9) return a;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        String intStr = a + "";
        char[] intArr = intStr.toCharArray();
        long reverseInt = 0;
        if (a > 0) {
            for (int i = intArr.length - 1; i >= 0; i--) {
                reverseInt += Integer.parseInt(String.valueOf(intArr[i])) * Math.pow(10, i);
                if (reverseInt > max) {
                    return 0;
                }
            }
        } else {
            for (int i = intArr.length - 1; i >= 1; i--) {
                //Math.pow(10, i - 1) i - 1 because if a < 0 then -12 -> [-, 1, 2] pow should eliminate symbol -
                reverseInt -= Integer.parseInt(String.valueOf(intArr[i])) * Math.pow(10, i - 1);
                if (reverseInt < min) {
                    return 0;
                }
            }
        }

        return (int)reverseInt;
    }

    public static void main(String[] args) {
        int res = new J7_Reverse_Integer().solution(Integer.MAX_VALUE - 36);
        System.out.println(res);
        res = new J7_Reverse_Integer().solution(-12);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}