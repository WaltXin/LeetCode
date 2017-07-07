package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 06/07/2017.
 */
public class J209_Minimux_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = (1 << 31) - 1;

        while (i < nums.length) {
            sum += nums[i++];

            while (sum >= s) {
                min = Math.min(min,i - j);
                sum -= nums[j++];
            }

        }
        if (min == (1<<31) - 1) {
            return 0;
        } else {
            return min;
        }
    }
    @Test
    public void test() {
        assertEquals(2, new J209_Minimux_Size_Subarray_Sum().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
