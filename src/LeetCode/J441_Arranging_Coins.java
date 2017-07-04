package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 04/07/2017.
 */
public class J441_Arranging_Coins {
    public int arrangeCoins(int n) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((0.5 * mid * mid + 0.5 * mid) <= n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    @Test
    public void test() {
        assertEquals(2,new J441_Arranging_Coins().arrangeCoins(5));
        assertEquals(3,new J441_Arranging_Coins().arrangeCoins(8));
        assertEquals(1,new J441_Arranging_Coins().arrangeCoins(2));
        assertEquals(2,new J441_Arranging_Coins().arrangeCoins(4));
    }
}
