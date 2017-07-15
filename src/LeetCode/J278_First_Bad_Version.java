package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 15/07/2017.
 */
public class J278_First_Bad_Version {

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid) == true) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean isBadVersion(int n) {
        if (n >= 10) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        assertEquals(10, new J278_First_Bad_Version().firstBadVersion(20));
    }
}


