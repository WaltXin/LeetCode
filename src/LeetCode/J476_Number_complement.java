package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 26/06/2017.
 */
public class J476_Number_complement {
    public int findComplement(int num) {
        if (num == Integer.MAX_VALUE) return 0;
        int leftOne = 0;
        for (int i = 0; i <= 32; i++) {
            if (((1 << i) - 1) > num) {
                leftOne = i - 1;
                break;
            }
        }
        return (~num) & ((1 << leftOne) - 1);
    }

    @Test
    public void test() {
        System.out.print(Integer.MAX_VALUE);
        assertEquals(1,new J476_Number_complement().findComplement(2147483646));
        assertEquals(2,new J476_Number_complement().findComplement(5));
    }
}
