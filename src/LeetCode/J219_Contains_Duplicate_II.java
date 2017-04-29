package LeetCode;

import java.util.HashSet;

public class J219_Contains_Duplicate_II {

	public static void main(String[] args) {
		int[] arr = {1,2,2,2,4};
		System.out.println(containsNearbyDuplicate(arr,2));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1 || k <= 0) return false;
		  
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
		    if (!set.add(nums[i])) return true;
		    
		    if (i >= k) {
		        set.remove(nums[i - k]);
		    }
		}
		return false;
    }

}
