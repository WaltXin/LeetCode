package LeetArray;

public class J189_Rotate_Array {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int[] res = solution(arr, 2);
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	//O(n):2n space:O(1), reverse 3 times
	public static int[] solution(int[] arr, int k) {
		k = k % arr.length;
		if (k == 0) return arr;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int tem = arr[low];
			arr[low] = arr[high];
			arr[high] = tem;
			low ++;
			high --;
		}
		//7,6,5,4,3,2,1
		low = 0;
		high = k - 1;
		while (low <= high) {
			int tem = arr[low];
			arr[low] = arr[high];
			arr[high] = tem;
			low ++;
			high --;
		}
		
		//6,7,5,4,3,2,1
		low = k;
		high = arr.length - 1;
		while (low <= high) {
			int tem = arr[low];
			arr[low] = arr[high];
			arr[high] = tem;
			low ++;
			high --;
		}
		//6,7,1,2,3,4,5
		return arr;
	}
	
}
