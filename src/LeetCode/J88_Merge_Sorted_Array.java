package LeetCode;

public class J88_Merge_Sorted_Array {
	
	public static void main(String[] args) {
		int[] arr1 = {2,2,5,0,0,0};
		int[] arr2 = {1,3,4};
		int[] res = solution(arr1,arr2);
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(int[] arr1, int[] arr2) {
		//merge arr2 to arr1, assume arr1 size is big to hold all arr2 elements in
		int index = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = index; j < arr1.length; j++) {
				if (arr2[i] <= arr1[j]) {
					//insert arr2[i] in arr1 j position,shift arr1(j - arr1.length - 1)
					//shift better from m+1 -> m in case overflow
					for (int m = arr1.length - 2; m >= j; m--) {
						arr1[m + 1] = arr1[m];
					}
					arr1[j] = arr2[i];
					index = j;
					break;
				}
			}
		}
		return arr1;
	}
}
