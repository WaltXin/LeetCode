package LeetArray;

public class J485_Max_Consecutive_Ones {

	public static void main(String[] args) {
		int[] arr = {1,0,0,0,1,1,1,1};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] arr) {
		int result = 0;
		int count = 0;
		//O(n) [1,n]
		for (int i = 0; i <= arr.length - 1; i++) {
			if(arr[i] == 1) {
				count++;
				result = Math.max(count, result);
			} else {
				count = 0;
			}
		}		
		return result;
	}

}
