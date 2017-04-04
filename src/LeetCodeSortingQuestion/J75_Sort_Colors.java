package LeetCodeSortingQuestion;

public class J75_Sort_Colors {

	public static void main(String[] args) {
		int[] arr = {1,0,1,1,2,0,0,2};
		SortColor(arr);
	}
	
	public static void SortColor(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		for (int i = low; i <= high;) {
			if (arr[i] == 0) {
				int tem = arr[i];
				arr[i] = arr[low];
				arr[low] = tem;
				low++; i++;
			} else if(arr[i] == 2) {
				int tem = arr[i];
				arr[i] = arr[high];
				arr[high] = tem;
				high--;
				//in here i don't do i++ step, because the value in high you don't know is 2 
			} else {
				i++;
			}
		}
		for (int i:arr) {
			System.out.println(i);
		}
	}
}
