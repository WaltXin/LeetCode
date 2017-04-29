package LeetCode;

public class J268_Missing_Number {

	public static void main(String[] args) {
		int[] arr = {1, 2, 5, 3, 6, 0};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] nums) {
		int n = nums.length + 1;
		//0 - n summary  [0, n] sn = n * (al + an) / 2 --> sn = n * an / 2 because a1 = 0 && an = n - 1
		int summary = n * (n - 1) / 2;
		int arrSum = 0;
		for (int i : nums) {
			arrSum += i;
		}
		return summary - arrSum;
		
	}

}
