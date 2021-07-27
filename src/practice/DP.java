package practice;

import junit.framework.TestCase;
import org.junit.Test;

public class DP {
    public int maxSeparateNums() {
        int[] arr = {1,2,4,1,7,8,3};
        /**
         *       |{   pick: opt(i - 2) + arr[i]
         * opt(i)|
         *       |{   nopick: opt(i - 1)
         *
         *    i = 0 pick first value
         *    i = 1 pick max one
         * */

        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Math.max(arr[0],arr[1]);

        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0],arr[1]);
        for (int i = 2; i < arr.length; i++) {
            opt[i] = Math.max(opt[i - 2] + arr[i], opt[i - 1]);
        }
        return opt[arr.length - 1];
    }
    /*@Test
    public void testRes() {
        TestCase.assertEquals(15, maxSeparateNums());
    }*/


    //n sum
    public boolean nSum() {
        int[] arr = {1,2,4,1,7,8,3};
        int S = 12;
        if (arr.length == 1) return arr[0] == S;

        boolean[][] dp = new boolean[arr.length][S + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= S; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (arr[i] == i) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                else if (arr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
                }
            }
        }
        return dp[arr.length - 1][S];

        //return recursion(arr, arr.length - 1, S);
    }
    public boolean recursion(int[] arr, int i, int S) {
        if (S == 0) return true;
        if (arr[i] > S) {
            recursion(arr, i - 1, S);
        }
        boolean A = recursion(arr, i - 1, S - arr[i]);
        boolean B = recursion(arr, i - 1, S);
        return A || B;
    }

    public int takeMoneyWisely() {
        int[] arr = {6,1,1};
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        int max = 0;

        for (int i = 1; i <= arr.length; i++) {
            dp[i][arr.length] = dp[i-1][arr.length] + i * arr[i-1];
        }

        for (int j = arr.length - 1; j >= 0; j--) {
            dp[0][j] = dp[0][j + 1] + (arr.length - j) * arr[j];
        }

        max = Math.max(dp[0][0], dp[arr.length][arr.length]);

        for (int i = 1; i <= arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                int A = dp[i - 1][j] + ((arr.length - j) + i) * arr[i];
                int B = dp[i][j + 1] + ((arr.length - j) + i) * arr[j];
                dp[i][j] = Math.max(A,B);
            }
            max = Math.max(max, dp[i][i]);
            System.out.println("i " + i);
        }

        for (int i = 0; i <= arr.length; i++) {
            System.out.println();
            for (int j = 0; j <= arr.length; j++) {
                if (dp[i][j] < 9)
                    System.out.print(dp[i][j] + "    ");
                else
                    System.out.print(dp[i][j] + "   ");
            }
        }
        System.out.println(max);
        return max;
    }

    /*@Test
    public void testMaxMoney() {
        TestCase.assertEquals(10, takeMoneyWisely());
    }*/


    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new DP().takeMoneyWisely();
    }

}
