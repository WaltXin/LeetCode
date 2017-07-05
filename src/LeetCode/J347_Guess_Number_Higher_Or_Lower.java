package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 05/07/2017.
 */
public class J347_Guess_Number_Higher_Or_Lower {
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int guess(int m) {
        int target = 45;
        if (m == target) {
            return 0;
        } else if (m > target) {
            return -1;
        } else {
            return 1;
        }
    }

    @Test
    public void test() {
        assertEquals(45,new J347_Guess_Number_Higher_Or_Lower().guessNumber(80));
    }
}
