package InterviewQuestions;

/**
 * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
 * Signature
 * bool areTheyEqual(int[] arr_a, int[] arr_b)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if B can be made equal to A, return false otherwise.
 * Example
 * A = [1, 2, 3, 4]
 * B = [1, 4, 3, 2]
 * output = true
 * After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 *
 * */
public class ReverseToMakeEqual {
    /**
     * The key idea is to list the situation,
     * there are 3 conditions,
     * 1,2,3,4,5  vs 3,2,1,4,5
     * 1,2,3,4,5  vs 1,2,3,5,4
     * 1,2,3,4,5  vs 1,4,3,2,5
     * After analysis, we found out that, we just need to know the left and right boundary of swap, if valid, must have a left&right boundary
     *
     * */
    boolean areTheyEqual(int[] array_a, int[] array_b) {
        if (array_a.length != array_b.length)
            return false;

        int n = array_a.length, left = 0, right = n - 1;
        while (array_a[left] == array_b[left])
            left++;

        while (array_a[right] == array_b[right])
            right--;

        for (int i = left; i <= right; i++) {
            if (array_a[i] != array_b[right + left - i])
                return false;
        }

        return true;
    }
}
