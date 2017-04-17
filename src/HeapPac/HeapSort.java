package HeapPac;

/**
 * Array Start from 0
 * Then: parent (i - 1) / 2
 *       LeftChild 2 * i + 1
 *       RightChild 2 * i + 2
 *       The first Un_leaf node is (count - 1) / 2
 * 
 * */


class Heap{	
	public void HeapSort(int[] arr) {
		//the last un_leaf node is
		int length = arr.length;
		int unLeaf = (length - 1)/2;
		for (int i = unLeaf; i >=0; i--) {
			ShiftDown(arr, i);
		}
		for (int i = length - 1; i > 0; i--) {
			int tem = arr[length - 1];
			arr[length - 1] = arr[0];
			arr[0] = tem;
			ShiftDown(arr, 0);
		}
		
	}
	
	public void ShiftDown(int[] arr, int k) {
		int length = arr.length;
		while (2 * k + 1 < length) {
			int j = 2 * k + 1;
			if (j + 1 < length && arr[j + 1] > arr[j]) {
				j++;
			}
			if (arr[k] >= arr[j]) {
				break;
			}
			int tem = arr[k];
			arr[k] = arr[j];
			arr[j] = tem;
			k = j;
		}
	}
}

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 3, 4, 7, 9, 8};
		Heap heap = new Heap();
		heap.HeapSort(arr);
	}

}
