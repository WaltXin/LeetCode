package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 26/06/2017.
 */
public class J477_Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int i = 0; i <32; i++) {
            int zero = 0;
            for (int num : nums) {
                if ((num & (1 << i)) == 0) {
                    zero++;
                }
            }
            count += zero * (nums.length - zero);
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(6,new J477_Total_Hamming_Distance().totalHammingDistance(new int[]{4,14,2}));
    }
}
