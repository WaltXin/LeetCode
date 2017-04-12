package HeapPac;

import java.util.Random;

public class HeapClass {
	
	int capacity;
	int[] HeapTree;
	
	int count = 0;
	
	public HeapClass(int capacity) {
		this.capacity = capacity;
		HeapTree = new int[this.capacity];
	}

	public int Size(){
		return HeapTree.length;
	}
	
	public boolean IsEmpty(){
		return capacity == 0;
	}
	
	public void InsertHeapTree(int item) {
	
		if (count + 1 < capacity) {	
			HeapTree[count + 1] = item;
			count ++; 
			ShiftUp(count);
		}
	}
	
	private void ShiftUp(int k) {
		while (k > 1 && HeapTree[k] > HeapTree[k/2]) {
			int tem = HeapTree[k];
			HeapTree[k] = HeapTree[k/2];
			HeapTree[k/2] = tem;
			k = k/2;
		}
	}
	
	public int[] Tree() {
		return HeapTree;
	}
	
	public static void main(String[] args) {
		HeapClass heap = new HeapClass(25);
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			int value = rand.nextInt(40);
			heap.InsertHeapTree(value);
		}
		int[] result = heap.Tree();
		for (int i:result) {
			System.out.print(i + " ");
		}
	}
}
