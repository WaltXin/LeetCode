package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 03/07/2017.
 */
public class J162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l+r)/2;
            if(nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }

    @Test
    public void test() {
        assertEquals(0,new J162_Find_Peak_Element().findPeakElement(new int[]{3,2,1}));
        assertEquals(2,new J162_Find_Peak_Element().findPeakElement(new int[]{1,2,3,1}));
    }
}
