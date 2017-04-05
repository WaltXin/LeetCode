package Sorting;

public class MergeSort {

	public static void main(String[] args) {
		//200k number 0.015 sec power of algorithm
		int arr[] = JavaHelper.arrayGenerator(200000, 10, 300);
		long t1 = System.currentTimeMillis();
		int[] result = mergeSort(arr);
		long t2 = System.currentTimeMillis();
		float millSec = t2 - t1;
		float sec = (millSec / 1000) % 60;
		System.out.println(sec);
	}
	
	public static int[] mergeSort(int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		_mergeSort(arr, l, r);
		return arr;
	}
	
	public static void _mergeSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int mid = (l + r)/2;
		_mergeSort(arr, l, mid);
		_mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}
	
	public static void merge(int[] arr, int l, int mid, int r) {
		int[] aux = new int[r - l + 1];
		for (int i = l; i <= r; i++) {
			aux[i - l] = arr[i];
		}
		int i = l;
		int j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = aux[j - l];
				j++;
			} else if (j > r){
				arr[k] = aux[i - l];
				i++;
			}else if (aux[i - l] > aux[j - l]) {
				arr[k] = aux[j - l];
				j++;
			} else {
				arr[k] = aux[i - l];
				i++;
			}
		}
	}

}
