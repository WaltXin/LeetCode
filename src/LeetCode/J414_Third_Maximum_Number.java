package LeetCode;

public class J414_Third_Maximum_Number {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] nums) {
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		int[] result = new int[3];
		int key = 0;
		//O(n) optimize search 3 times
		for (int i = 0; i < nums.length; i++) {
			//find the max value in nums [0,n)
			int max = nums[0];
			int min = nums[0];
			int maxindex = 0;
			int minindex = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] > max) {
					max = nums[j];
					maxindex = j;
				}
				if (nums[j] < min) {
					min = nums[j];
					minindex = j;
				}
			}
			
			nums[maxindex] = nums[minindex];
			if (i == 0) {
				result[key] = max;
				key ++;
			}
			if (key > 2) {
				break;
			}
			if (i > 0) {
				if (max < result[key - 1]) {
					result[key] = max;
					key++;
				}
			}
			
		}
		if (key < 3) {
			return result[0];
		} else {
			return result[2];
		}
	}

}
