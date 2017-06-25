package LeetCode;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by walt on 25/06/2017.
 */
public class J461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        //Return Integer.bitCount(x ^ y);
        int n = x ^ y;
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(1,new J461_Hamming_Distance().hammingDistance(2,3));
    }
}
