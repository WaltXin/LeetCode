package LeetCode;

public class J136_Single_Number {
	public static void main(String[] args) {
		int[] arr = {1,2,2,1,5,7,7};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] arr) {
		//every elements in arr appears twice except one
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			res ^= arr[i];
		}
		return res;
	}

}

