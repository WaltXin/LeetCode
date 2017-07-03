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
            int mid1 = (l+r)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2]) {
                l = mid2;
            }
            else {
                r = mid1;
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
