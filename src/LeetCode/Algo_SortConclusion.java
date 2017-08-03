package LeetCode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Random;
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
	
	public void __mergeSort(int[] arr, int le, int ri) {
		if (le >= ri) return;
		int mid = le + (ri - le) / 2;
		__mergeSort(arr, le, mid);
		__mergeSort(arr, mid + 1, ri);
		merge(arr, le, mid, ri);
	}
	
	public void merge(int[] arr, int le, int mid, int ri) {
		//create auxiliary array to store the current array value
		int[] aux = new int[ri - le + 1];
		for (int i = le; i <= ri; i++) {
			aux[i - le] = arr[i];
		}
		//two pointer i and j. 1,3,5   2,4,6  i is 1 and j is 2.
		int i = le;
		int j = mid + 1;
		
		//because we have le's offset we need minus le to get aux array's value
		for (int k = le; k <= ri; k++) {
			if (i > mid) {
				arr[k] = aux[j - le];
				j++;
			} else if (j > ri) {
				arr[k] = aux[i - le];
				i++;
			} else if (aux[i - le] < aux[j - le]) {
				arr[k] = aux[i - le];
				i++;
			} else {
				arr[k] = aux[j - le];
				j++;
			}
		}
	}
	
	public int[] quickSort(int[] arr) {
		__quickSort(arr, 0, arr.length - 1);
		return arr;
	}
	
	public void __quickSort(int[] arr, int l, int r) {
		if (l >= r) return;
		int p = partition(arr, l, r);
		__quickSort(arr, l, p - 1);
		__quickSort(arr, p + 1, r);
	}
	
	public int partition(int[] arr, int l, int r) {
		Random rand = new Random();
		int randVal = rand.nextInt(r - l + 1) + l;
		//Swap a random value to increase the balance
		int temV = arr[l];
		arr[l] = arr[randVal];
		arr[randVal] = temV;
		int v = arr[l];
		//arr[l + 1, i] < v;
		//arr[i + 1, j] > v;
		int i = l;
		int j = i + 1;
		while (j <= r) {
			if (arr[j] < v) {
				int tem = arr[i + 1];
				arr[i + 1] = arr[j];
				arr[j] = tem;
				i++;
				j++;
			} else {
				j++;
			}
		}

		//Swap v and i
		int temVS = arr[l];
		arr[l] = arr[i];
		arr[i] = temVS;
		return i;
	}
	
	public int[] genArray(int num, int lLimit, int rLimit) {
		Random rand = new Random();
		int[] res = new int[num];
		for (int i = 0; i < num; i++) {
			int randVal = rand.nextInt(rLimit - lLimit + 1) + lLimit;
			res[i] = randVal;
		}
		return res;
	}
	
	public int[][] generatedArray(int num, int lLimit, int rLimit) {
		int[][] res = new int[2][num];
		int[] arr = genArray(num, lLimit, rLimit);
		int[] mergedSort = mergeSort(arr);
		res[0] = arr;
		res[1] = mergedSort;
		return res;
	}
	
	public int[] calRunTime(String str, int[] arr) {
		long startTime = System.currentTimeMillis();
		int[] res = new int[arr.length];
		switch(str) {
			case "selectionSort": res = new Algo_SortConclusion().selectionSort(arr);
				  	break;
			case "insertSort": res = new Algo_SortConclusion().insertSort(arr);
					break;
			case "mergeSort": res = new Algo_SortConclusion().mergeSort(arr);
					break;
			case "quickSort": res = new Algo_SortConclusion().quickSort(arr);
					break;
				
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(str + ": " + elapsedTime + " millisecond");
		return res;
	}
	

    @Test
    public void test() {
    	int[][] arr = generatedArray(100000, 1, 10000);
    	int[] randomArray = arr[0];
    	int[] sortedArray = arr[1];
    	System.out.println("1 second = 1000 millisecond");
    	assertArrayEquals(sortedArray, new Algo_SortConclusion().calRunTime("selectionSort", randomArray));
    	assertArrayEquals(sortedArray, new Algo_SortConclusion().calRunTime("insertSort", randomArray));
    	assertArrayEquals(sortedArray, new Algo_SortConclusion().calRunTime("mergeSort", randomArray));
    	assertArrayEquals(sortedArray, new Algo_SortConclusion().calRunTime("quickSort", randomArray));
    }
}
