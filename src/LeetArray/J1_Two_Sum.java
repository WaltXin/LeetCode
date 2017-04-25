package LeetArray;

public class J1_Two_Sum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,8,9};
		int target = 3;
		int[] result = solution(nums,target);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j ++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}
		return result;
	}

}
