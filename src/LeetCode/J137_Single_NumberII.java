package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 28/06/2017.
 */
public class J137_Single_NumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int zero = 0;
            for (int num : nums) {
                if ((num & (1<<i)) == 0) {
                    zero++;
                }
            }
            result |= zero % 3 != 0 ? 0 : (1 << i);
        }
        return result;
    }
    @Test
    public void test() {
        assertEquals(6,new J137_Single_NumberII().singleNumber(new int[]{1,1,1,2,2,2,5,5,5,6}));
    }
}
