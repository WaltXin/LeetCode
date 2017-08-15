package BinaryTreeSearch;

public class BinarySearch {

	//[l,r]
	public int search(int[] arr, int target) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (r - l) / 2 + l;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,6,9,13};
		System.out.println(new BinarySearch().search(arr, 6));
	}

}
