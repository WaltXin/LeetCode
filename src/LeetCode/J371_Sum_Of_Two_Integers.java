package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 26/06/2017.
 */
public class J371_Sum_Of_Two_Integers {
    public static int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int res = a ^ b;
        int carry = (a & b) << 1;
        return getSum(res,carry);
    }

    public static int getSubstruction(int a, int b) {
        //a - b == -b + a
        return getSum(((~b) + 1), a);
    }
    @Test
    public void test() {
        assertEquals(8,new J371_Sum_Of_Two_Integers().getSum(3,5));
        assertEquals(-2,new J371_Sum_Of_Two_Integers().getSubstruction(3,5));
    }
}
