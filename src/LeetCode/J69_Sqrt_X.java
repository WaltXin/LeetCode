package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 08/07/2017.
 */
public class J69_Sqrt_X {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1;
        int r = (1 << 31) - 1;
        while (true) {
            int mid = l + (r - l) / 2;
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                }
                l = mid + 1;
            }
        }
    }
    @Test
    public void test() {
        assertEquals(1, new J69_Sqrt_X().mySqrt(2));
        assertEquals(2, new J69_Sqrt_X().mySqrt(4));
    }
}
