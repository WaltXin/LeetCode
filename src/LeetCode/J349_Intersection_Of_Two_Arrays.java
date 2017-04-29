package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class J349_Intersection_Of_Two_Arrays {

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] res = intersection(nums1,nums2);
		for (int i : res) System.out.println(i);
	}
	
	 public static int[] intersection(int[] nums1, int[] nums2) {
	        if (nums1 == null && nums2 == null) return null;
	        if (nums1 == null || nums2 == null) return null;
	        Set<Integer> set = new HashSet<Integer>();
	        for (int n1 : nums1) {
	            for (int n2 : nums2) {
	                int r = n1 ^ n2;
	                if (r == 0) {
	                    set.add(n1);
	                }
	            }
	        }
	        int [] result = new int[set.size()];
	        int loop = 0;
	        for (int i : set) {
	            result[loop++] = i;
	        }
	        return result;
	    }

}
