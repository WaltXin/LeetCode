package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 10/07/2017.
 */
public class Algo_BinarySearchConclusion {
    //Ascending array, find arr[i] == target , if not exist, return -1
    public int search_1(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    @Test
    public void test() {
        assertEquals(3, new Algo_BinarySearchConclusion().search_1(new int[]{1,3,9,10,23},10));
    }
}
