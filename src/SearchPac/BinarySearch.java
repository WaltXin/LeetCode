package SearchPac;

//TODO: floor && ceil
public class BinarySearch {

	public static int binarySearch(int[] arr, int target) {
		//search from[l,r]
		int l = 0;
		int r = arr.length - 1;
		
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] < target) {
				//target in right side
			    //search from[mid + 1, r]
				l = mid + 1;
			} else {
				//search from[l, mid - 1]
				r = mid - 1;
			}
		}
		return -1;
	}
	
	public static int recursiveBinarySearch(int[] arr, int l, int r, int target) {
		//search from[l,r]
		int mid = (l + r) / 2;
		if (l > r) {
			return -1;
		}
		if (arr[mid] == target) {
			return mid;
		}
		if (arr[mid] < target) {
			l = mid + 1;
			return recursiveBinarySearch(arr, l, r, target);
		} else {
			r = mid - 1;
			return recursiveBinarySearch(arr, l, r, target);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,4,7,9};
		System.out.println(binarySearch(arr,7));
		System.out.println(recursiveBinarySearch(arr,0, arr.length - 1, 7));
	}

}
