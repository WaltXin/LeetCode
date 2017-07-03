package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 03/07/2017.
 */
public class J367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid == num){
                return true;
            }
            else if (mid * mid < num) {
                l = (int)mid + 1;
            } else {
                r = (int)mid - 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(true,new J367_Valid_Perfect_Square().isPerfectSquare(16));
        assertEquals(true,new J367_Valid_Perfect_Square().isPerfectSquare(1));
        assertEquals(false,new J367_Valid_Perfect_Square().isPerfectSquare(12));
        assertEquals(false,new J367_Valid_Perfect_Square().isPerfectSquare(2147483647));
    }
}
