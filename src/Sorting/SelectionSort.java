package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = JavaHelper.arrayGenerator(20, 10, 300);
		int[] result = selectionSort(arr);
		JavaHelper.printArray(result);
	}
	
	public static int[] selectionSort(int[] arr){
		//1. Find the min value's index
		//2. Replace the min value with current index value
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
