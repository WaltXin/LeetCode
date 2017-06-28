package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 28/06/2017.
 */
public class J191_Number_Of_Onebit {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (1 & (n >> i));
        }
        return count;
    }
    @Test
    public void test() {
        assertEquals(32, new J191_Number_Of_Onebit().hammingWeight(-1));
    }
}
