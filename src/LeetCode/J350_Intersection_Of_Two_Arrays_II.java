package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by walt on 01/07/2017.
 */
public class J350_Intersection_Of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                al.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2,2},new J350_Intersection_Of_Two_Arrays_II().intersect(new int[]{1,2,2,1},new int[]{2,2}));
    }

}
