package HeapPac;

import java.util.Random;
/**
 * Use Complete Binary Tree(Parent always bigger(smaller) than children left node always exist(except final left code)
 *          53(1)
 *        /      \
 *       48(2)   21(3)
 *      /   \     /   \
 *    36(4) 9(5) 11(6)       
 *    
 *   Parent: i/2
 *   Left Node: 2*i
 *   Right Node: 2*i + 1
 *   ShiftUp add value in last one and compare with parent to move the node to the right place
 *   ShifDown remove value in the head and add last node in to head then move node to the right place 
 * */


public class HeapClass {
	
	int capacity;
	int[] HeapTree;
	
	int count = 0;
	
	public HeapClass(int capacity) {
		this.capacity = capacity;
		HeapTree = new int[this.capacity];
	}
	
	private void ShiftUp(int k) {
		while (k > 1 && HeapTree[k] > HeapTree[k/2]) {
			int tem = HeapTree[k];
			HeapTree[k] = HeapTree[k/2];
			HeapTree[k/2] = tem;
			k = k/2;
		}
	}
	
	private void ShiftDown(int k) {	
		while (2 * k <= count) {
			int j = 2 * k;
			if (j + 1 <= count && HeapTree[j + 1] > HeapTree[j]) {
				j ++;
			}
			if (HeapTree[k] > HeapTree[j]) {
				break;
			}
			int tem = HeapTree[k];
			HeapTree[k] = HeapTree[j];
			HeapTree[j] = tem;
			k = j;
		}
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
	
	public int DeleteFirstNode() {
		if (count > 1) {
			int res = HeapTree[1];
			//Swap head node with last node
			int tem = HeapTree[count];
			HeapTree[count] = HeapTree[1];
			HeapTree[1] = tem;
			count --;
			ShiftDown(1);			
			return res;
		} else {
			return -1;
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
		System.out.println("\n");
		for (int i = 0; i <= 25; i++) {
			System.out.println(heap.DeleteFirstNode());
		}
	}
}
