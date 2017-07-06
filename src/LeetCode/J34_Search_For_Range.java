package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by walt on 06/07/2017.
 */
public class J34_Search_For_Range {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        //search the index min first
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int[] result = new int[2];
        if (nums[l] == target) {
            result[0] = l;
        } else if (nums[r] == target) {
            result[0] = r;
        } else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        //search the index max later
        int l1 = 0;
        int r1 = nums.length - 1;
        while (l1 + 1 < r1) {
            int mid = l1 + (r1 - l1) / 2;
            if (nums[mid] <= target) {
                l1 = mid;
            } else {
                r1 = mid - 1;
            }
        }
        if (nums[r1] == target) {
            result[1] = r1;
        } else if(nums[l1] == target) {
            result[1] = l1;
        }
        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3,4}, new J34_Search_For_Range().searchRange(new int[]{5, 7, 7, 8, 8, 10},8));
        assertArrayEquals(new int[]{0,0}, new J34_Search_For_Range().searchRange(new int[]{8},8));
        assertArrayEquals(new int[]{0,1}, new J34_Search_For_Range().searchRange(new int[]{8,8},8));
        assertArrayEquals(new int[]{-1,-1}, new J34_Search_For_Range().searchRange(new int[]{0,9},8));
        assertArrayEquals(new int[]{-1,-1}, new J34_Search_For_Range().searchRange(new int[]{0},8));
        assertArrayEquals(new int[]{0,0}, new J34_Search_For_Range().searchRange(new int[]{8,10},8));
        assertArrayEquals(new int[]{1,1}, new J34_Search_For_Range().searchRange(new int[]{1,4},4));
        assertArrayEquals(new int[]{1,2}, new J34_Search_For_Range().searchRange(new int[]{1,2,2},2));
    }
}
