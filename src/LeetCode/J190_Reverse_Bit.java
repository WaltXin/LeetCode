package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 29/06/2017.
 */
public class J190_Reverse_Bit {
    public int reverseBits(int n) {
        int result = (n >> 31) & 1;
        int index = 1;
        for (int i = 30; i >= 0; i--) {
            int fBit = (n >> i) & 1;
            result |= fBit << index;
            index++;
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals(-1,new J190_Reverse_Bit().reverseBits(-1));
    }
}
