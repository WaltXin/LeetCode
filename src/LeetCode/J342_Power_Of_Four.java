package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 28/06/2017.
 */
public class J342_Power_Of_Four {
    public boolean isPowerOfFour(int num) {
        return ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
    }
    @Test
    public void test() {
        assertEquals(false, new J342_Power_Of_Four().isPowerOfFour(2));
        assertEquals(true, new J342_Power_Of_Four().isPowerOfFour(4));
        assertEquals(true, new J342_Power_Of_Four().isPowerOfFour(64));
    }
}
