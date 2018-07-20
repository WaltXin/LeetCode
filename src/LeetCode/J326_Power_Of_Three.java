package LeetCode;

public class J326_Power_Of_Three {
    public boolean isPowerOfThree(int n) {
        int i = 0;
        while (Math.pow(3, i) < n) {
            i++;
        }
        if (Math.pow(3, i) == n) return true;
        return false;
    }
    public boolean isPowerOfThree1(int n) {
        while (n > 0) {
            if (n == 1) return true;
            else {
                if (n % 3 == 0) {
                    n = n / 3;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new J326_Power_Of_Three().isPowerOfThree1(1);
        long val = (long) Math.pow(3, 20);
        System.out.println(val);
        System.out.println(Integer.MAX_VALUE);
    }
}
