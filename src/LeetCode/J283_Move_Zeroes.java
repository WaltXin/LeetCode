package LeetCode;

public class J283_Move_Zeroes {

	public static void main(String[] args) {
		int[] arr = { 0 ,1, 0 , 2};
		int[] res = solution(arr);
		int[] res1 = solutionInPlace(arr);
		for (int i : res1) {
			System.out.println(i);
		}
		
	}
	
	//can use array copy
	public static int[] solution(int[] arr) {
		int index = 0;
		int[] array = new int[arr.length];
		for (int i = 0; i <arr.length; i++) {
			if (arr[i] != 0) {
				array[index] = arr[i];
				index++;
			}
		}
		return array;
	}
	
	//do in place using offset
	public static int[] solutionInPlace(int[] nums) {
		int zeroIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroIndex ++;
				continue;
			}
			int offset = i - zeroIndex;
			int tem = nums[i];
			nums[i] = nums[offset];
			nums[offset] = tem;
		}
		return nums;
	}

}
