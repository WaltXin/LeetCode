package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 03/07/2017.
 */
public class J153_Find_Minimul_In_Rotated_SortedArray {
    public int findMin(int[] nums) {
        int min = 1 << 31 - 1;
        int l = 0;
        int r = nums.length - 1;
        if (nums[0] > nums[(nums.length - 1) / 2]) {
            l = 0;
            r = (nums.length - 1) / 2;
        } else {
            if (nums[0] < nums[nums.length - 1]) {
                return nums[0];
            }
        }

        while (l <= r) {
            if (nums[l] > nums[r]) {
                min = Math.min(min, nums[r]);
                r--;
            } else {
                min = Math.min(nums[l], min);
                l++;
            }
        }
        return min;
    }

    @Test
    public void test() {
        assertEquals(0,new J153_Find_Minimul_In_Rotated_SortedArray().findMin(new int[]{4,5,6,7,0,1,2}));
        assertEquals(0,new J153_Find_Minimul_In_Rotated_SortedArray().findMin(new int[]{0,1,2}));
        assertEquals(1,new J153_Find_Minimul_In_Rotated_SortedArray().findMin(new int[]{1,2}));
        assertEquals(1,new J153_Find_Minimul_In_Rotated_SortedArray().findMin(new int[]{2,1}));
    }
}