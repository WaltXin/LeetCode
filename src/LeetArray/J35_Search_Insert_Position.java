package LeetArray;

public class J35_Search_Insert_Position {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7};
		int res1 = binarySolution(arr, 2);
		System.out.println(res1);
	}
	
	public static int solution(int[] arr, int target) {
		int i = 0;
		while (i < arr.length) {
			if (target <= arr[i]) return i;
			if (target > arr[i]) i++;
		}
		return i;
	}
	
	public static int binarySolution(int[] arr, int target) {
		int l = 0;
		int r = arr.length - 1;
		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (target == arr[mid]) return mid;
			if (target < arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

}
