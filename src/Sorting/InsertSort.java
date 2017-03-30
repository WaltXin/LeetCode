package Sorting;

public class InsertSort {

	public static void main(String[] args) {
		JavaHelper.printArray(InsertSort(JavaHelper.arrayGenerator(8, 2, 18)));
	}
	
	public static int[] InsertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int tem = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tem;
				} else {
					break;
				}
			}
		}
		return arr;
	}

}
