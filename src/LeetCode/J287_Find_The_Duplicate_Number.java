package LeetCode;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 02/07/2017.
 */
public class J287_Find_The_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num,1);
            } else {
                return num;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(1,new J287_Find_The_Duplicate_Number().findDuplicate(new int[]{1,1}));
    }
}
