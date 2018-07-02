package LeetCode;

public class J27_Remove_Element {

	public static void main(String[] args) {
		int[] arr = {0,1,2,2,3,0,4,2};
		int[] res = removeElement(arr,2);
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	 public static int[] removeElement(int[] nums, int val) {
	        int offset = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == val) {
	                offset ++;
	            } 
	            else {
	            //swap nums[i] and nums[i - offset]
	            int tem = nums[i - offset];
	            nums[i - offset] = nums[i];
	            nums[i] = tem;
	            }
	        }
	        return nums;
    }

}
