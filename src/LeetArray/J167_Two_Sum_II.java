package LeetArray;

public class J167_Two_Sum_II {

	public static void main(String[] args) {
		int[] arr = {2,3,4};
		int target = 6;
		for (int i : solution(arr,target)) {
			System.out.println(i);
		}
		
	}
	
	public static int[] solution(int arr[], int target) {
		int[] result = new int[2];
		if (arr.length <= 2) {
			result[0] = 1;
			result[1] = 2;
		}
		
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			if (arr[l] + arr[r] == target) {
				result[0] = l + 1;
				result[1] = r + 1;
				break;
			}
			if (arr[l] + arr[r] > target) {
				r--;
			} else {
				l++;
			}
			
		}
		return result;
		
	}

}
