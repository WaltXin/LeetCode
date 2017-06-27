package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by walt on 26/06/2017.
 */
public class J260_Singer_NumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        //get last set bit(get last 1)
        diff &= -diff;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                //the bit is not set, because two different value will separate(one have zero set, one doesn't have zero set after XOR)
                result[0] ^= num;
            } else {
                //the bit is set
                result[1] ^= num;
            }
        }
        return result;
    }
    @Test
    public void test() {
        int[] test1  = {2,2,1,3};
        assertArrayEquals(new int[]{1,3},new J260_Singer_NumberIII().singleNumber(test1));
    }
}
