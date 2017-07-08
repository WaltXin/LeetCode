package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 08/07/2017.
 */
public class J69_Sqrt_X {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid > x) {
                r = mid - 1;
            } else {
                if ((mid + 1) * (mid + 1) > x) {
                    return mid;
                }
                l = mid + 1;
            }
        }
        return l;
    }
    @Test
    public void test() {
        assertEquals(1, new J69_Sqrt_X().mySqrt(2));
        assertEquals(2, new J69_Sqrt_X().mySqrt(4));
    }
}
