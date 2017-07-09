package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 09/07/2017.
 */
public class J50_Pow_X_N {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double ans = 1;
        long abs = Math.abs((long)n);
        while (abs > 0) {
            if ((abs & 1) == 1) ans *= x;
            x *= x;
            abs >>= 1;
        }
        if (n < 0) {
            return 1 / ans;
        } else {
            return ans;
        }
    }
    @Test
    public void test() {
        assertEquals(8, new J50_Pow_X_N().myPow(2,3),0.0001);
    }
}
