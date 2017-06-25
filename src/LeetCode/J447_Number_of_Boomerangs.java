package LeetCode;

import java.util.*;

/**
 * Created by walt on 23/06/2017.
 */
public class J447_Number_of_Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int length = points.length;
        if (length == 0) return 0;

        int count = 0;

        for (int i = 0;i < length;i++) {
            Map<Double,Integer> map = new HashMap<>();
            for (int j = 0;j < length;j++) {
                if(map.containsKey(calculateDistance(points[i],points[j]))) {
                    int value = map.get(calculateDistance(points[i],points[j]));
                    count += 2*value;
                    map.put(calculateDistance(points[i],points[j]),value+1);
                } else {
                    map.put(calculateDistance(points[i],points[j]),1);
                }
            }
        }
        return count;
    }
    public double calculateDistance(int[] A, int[] B) {
        return Math.sqrt(Math.pow((A[0] - B[0]),2) + Math.pow((A[1] - B[1]),2));
    }
}
