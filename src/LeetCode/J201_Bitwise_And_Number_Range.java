package LeetCode;

/**
 * Created by walt on 29/06/2017.
 */
public class J201_Bitwise_And_Number_Range {
    public int rangeBitwiseAnd(int m, int n) {
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
