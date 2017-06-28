package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 28/06/2017.
 */
public class J405_Convert_Number_To_Hex {
    public String toHex(int num) {
        if (num == 0) return "0";
        String res = "";
        for (int i = 31; i >= 0; i = i - 4) {
            int count = 0;
            if (((num >> i) & 1) == 1) {
                count += 8;
            }
            if (((num >> (i - 1)) & 1) == 1) {
                count += 4;
            }
            if (((num >> (i - 2)) & 1) == 1) {
                count += 2;
            }
            if (((num >> (i - 3)) & 1) == 1) {
                count += 1;
            }
            //System.out.print(sb);
            if (count == 0 && res != "") {
                res += "0";
            }
            if (count > 0 && count <= 9) {
                res += count;
            } else if (count == 10) {
                res += "a";
            } else if (count == 11) {
                res += "b";
            } else if (count == 12) {
                res += "c";
            } else if (count == 13) {
                res += "d";
            } else if (count == 14) {
                res += "e";
            } else if (count == 15) {
                res += "f";
            }
        }
        return res;
    }
    @Test
    public void test() {
        assertEquals("1a", new J405_Convert_Number_To_Hex().toHex(26));
        assertEquals("ffffffff", new J405_Convert_Number_To_Hex().toHex(-1));
        assertEquals("0", new J405_Convert_Number_To_Hex().toHex(0));
        assertEquals("10", new J405_Convert_Number_To_Hex().toHex(16));
    }
}
