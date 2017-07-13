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

    //[repeat arr]find the min index in arr, if not exist return -1;
    public static int search_2(int[] arr, int target) {
        if (target > arr[arr.length - 1] || target < arr[0]) return -1;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == target) {
            return l;
        } else {
            return -1;
        }
    }

    //[repeat arr]find the max index in arr, if not exist return -1;
    public static int search_3(int[] arr, int target) {
        if (target > arr[arr.length - 1] || target < arr[0]) return -1;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (arr[mid] <= target) {
                l = mid;
            } else {
                r = mid -1;
            }
        }
        if (arr[r] == target) {
            return r;
        } else {
            return -1;
        }
    }

    //find the insert position, if target exist return the target place if not exist return the insert place
    public static int search_4(int[] arr, int target) {
        if (target > arr[arr.length - 1])return arr.length;
        if (target < arr[0]) return 0;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    //[repeat arr]find the insert position, if target exist return the target place if not exist return the insert place
    public static int search_5(int[] arr, int target) {
        if (target > arr[arr.length - 1])return arr.length;
        if (target < arr[0]) return 0;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    //[repeat arr]find target repeat times in arr;
    public static int search_6(int[] arr, int target) {
        int first = search_2(arr,target);
        int last = search_3(arr,target);
        if (first == -1 || last == -1) {
            return 0;
        } else {
            return last - first +1;
        }
    }

    //[repeat arr]find the minimal absolute values position;
    public static int search_7(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == 0) {
            return 0;
        }
        if (l == 0) {
            return arr[l];
        } else {
            return l > Math.abs(l - 1) ? arr[l - 1] : arr[l];
        }

    }


    @Test
    public void test() {
        assertEquals(3, new Algo_BinarySearchConclusion().search_1(new int[]{1,3,9,10,23},10));
        assertEquals(1, new Algo_BinarySearchConclusion().search_2(new int[]{1,2,2,2,3,9,10,23},2));
        assertEquals(3, new Algo_BinarySearchConclusion().search_3(new int[]{1,2,2,2,3,9,10,23},2));
        assertEquals(1, new Algo_BinarySearchConclusion().search_4(new int[]{1,3,9,10,23},2));
        assertEquals(5, new Algo_BinarySearchConclusion().search_5(new int[]{1,2,2,2,3,9,10,23},4));
        assertEquals(3, new Algo_BinarySearchConclusion().search_6(new int[]{1,2,2,2,3,9,10,23},2));
        assertEquals(-2, new Algo_BinarySearchConclusion().search_7(new int[]{-6,-6,-2,-2,3,6,6,9}));
    }

}
