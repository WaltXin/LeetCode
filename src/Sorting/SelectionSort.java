package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = {1,4,3,2,8,5,6,9,7};
		int[] result = selectionSort(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static int[] selectionSort(int[] arr){
		//Find the min one's place and replace with current index's place
		
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int tem = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tem;
		}
		return arr;
	}

}
