package LeetCode;

public class J122_Best_Time_To_Buy_And_Sell_Stock_II {
    //[7,1,5,3,6,4]
    public int solution(int[] arr) {
        if (arr.length == 0) return 0;
        int maxSum = 0;
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            profit = Math.max(profit, 0);
            profit = arr[i] - arr[i - 1];
            if (profit > 0) {
                maxSum += profit;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int[] arr1 = {7,6,5};
        int[] arr2 = {5,6,7};
        int res = new J122_Best_Time_To_Buy_And_Sell_Stock_II().solution(arr2);
        System.out.println(res);
    }
}
