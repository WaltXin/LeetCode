package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
/**
 * Created by walt on 17/07/2017.
 */
public class Algo_SortConclusion {
	public int[] selectionSort(int[] arr) {
		for (int i = 0; i <= arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j <= arr.length - 1; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			int tem = arr[i];
			arr[i] = arr[index];
			arr[index] = tem;
		}
		return arr;
	}
	
	public int[] insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int swapVal = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1] > swapVal; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = swapVal;
		}
		return arr;
	}
	
	//Up down
	public int[] mergeSort(int[] arr) {
		__mergeSort(arr, 0, arr.length - 1);
		return arr;
	}
	
	public void __mergeSort(int[] arr, int l, int r) {
		if (l >= r) return;
		int mid = l + (r - l) / 2;
		__mergeSort(arr, l, mid);
		__mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}
	
	public void merge(int[] arr, int l, int mid, int r) {
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
			} else if (j > r) {
				arr[k] = aux[i - l];
				i++;
			} else if (aux[i - l] < aux[j - l]) {
				arr[k] = aux[i - l];
				i++;
			} else {
				arr[k] = aux[j - l];
				j++;
			}
		}
	}
	

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, new Algo_SortConclusion().selectionSort(new int[]{4,5,3,1,2,8,9,7,6}));
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, new Algo_SortConclusion().insertSort(new int[]{4,5,3,1,2,8,9,7,6}));
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, new Algo_SortConclusion().mergeSort(new int[]{4,5,3,1,2,8,9,7,6}));
    }
}
