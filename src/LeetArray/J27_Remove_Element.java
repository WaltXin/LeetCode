package LeetArray;

public class J27_Remove_Element {

	public static void main(String[] args) {
		int[] arr = {3,2,2,3};
		int[] res = removeElement(arr,3);
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	 public static int[] removeElement(int[] nums, int val) {
	        int index = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == val) {
	                index ++;
	                continue;
	            }
	            int offset = i - index;
	            int tem = nums[offset];
	            nums[offset] = nums[i];
	            nums[i] = tem;
	        }
	        
	        if (index == nums.length) {
	        	nums = null;
	        }
	        return nums;
    }

}
