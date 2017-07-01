package LeetCode;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 01/07/2017.
 */
public class J454_4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> ab_map = new HashMap<Integer,Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (ab_map.containsKey(sum)) {
                    ab_map.put(sum, ab_map.get(sum) + 1);
                } else {
                    ab_map.put(sum, 1);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = 0 - (C[i] + D[j]);
                if (ab_map.containsKey(sum)) {
                    count += ab_map.get(sum);
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(2,new J454_4SumII().fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2},new int[]{0,2}));
    }
}
