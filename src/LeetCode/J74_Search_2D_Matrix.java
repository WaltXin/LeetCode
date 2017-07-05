package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by walt on 05/07/2017.
 */
public class J74_Search_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || ((matrix.length == 1) && (matrix[0].length == 0))) return false;
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1]) return false;
        int l = 0;
        int r = matrix.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int lineLength = matrix[mid].length;
            //get the line's last value
            int value = matrix[mid][lineLength - 1];
            if (value == target) return true;
            if (value > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int line = l;
        int l1 = 0;
        int r1 = matrix[line].length - 1;
        while (l1 <= r1) {
            int mid = (l1 + r1) / 2;
            int value = matrix[line][mid];
            if (value == target) return true;
            if (value > target) {
                r1 = mid - 1;
            } else {
                l1 = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertEquals(true,
                new J74_Search_2D_Matrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 1));
        assertEquals(false,
                new J74_Search_2D_Matrix().searchMatrix(new int[][]{{1}}, 0));
    }
}
