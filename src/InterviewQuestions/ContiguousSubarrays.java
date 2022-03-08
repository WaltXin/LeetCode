package InterviewQuestions;

import java.util.Stack;

/**
 * You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfill the following conditions:
 * The value at index i must be the maximum element in the contiguous subarrays, and
 * These contiguous subarrays must either start from or end on index i.
 * Signature
 * int[] countSubarrays(int[] arr)
 * Input
 * Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * Size N is between 1 and 1,000,000
 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
 * Example:
 * arr = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]
 * Explanation:
 * For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
 * For index 1 - [4], [3, 4], [4, 1]
 * For index 2 - [1]
 * For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 * For index 4 - [2]
 *
 * */

public class ContiguousSubarrays {
    int[] countSubarrays(int[] arr) {
        int n = arr.length;
        Stack<Integer> rightStack = new Stack<>(); //idx
        Stack<Integer> leftStack = new Stack<>();
        int[] rightBound = new int[n];
        int[] leftBound = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && arr[rightStack.peek()] < arr[i])
                rightStack.pop();
            rightBound[i] = rightStack.isEmpty() ? n : rightStack.peek();
            rightStack.push(i);
        }

        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && arr[leftStack.peek()] < arr[i])
                leftStack.pop();
            leftBound[i] = leftStack.isEmpty() ? -1 : leftStack.peek();
            leftStack.push(i);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = -1;
            count += i - leftBound[i];
            count += rightBound[i] - i;
            res[i] = count;
        }

        return res;
    }
}
