package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 25/06/2017.
 */
public class J231_Power_Of_Two {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
    @Test
    public void test() {
        assertEquals(true, new J231_Power_Of_Two().isPowerOfTwo(4));
        assertEquals(false, new J231_Power_Of_Two().isPowerOfTwo(5));

    }
}
