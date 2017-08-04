package HeapPac;

//This type of heap can used for system privilege task.
//MaxHeap
public class IndexHeapClass {
	int count;
	int[] index;
	int[] data;
	
	private void shiftUp(int k) {
		while (k > 1 && data[index[k]] > data[index[k / 2]]) {
			//swap index[k] index[k / 2]
			int tem = index[k];
			index[k] = index[k / 2];
			index[k / 2] = tem;
			k = k / 2;
		}
	}
	
	private void shiftDown(int k) {
		while (2 * k <= count) {
			int j = 2 * k;
			if (j + 1 <= count && data[index[j + 1]] > data[index[j]]) {
				j++;
			}
			if (data[index[k]] > data[index[j]]) {
				return;
			}
			//swap index[k] index[j]
			int tem = index[k];
			index[k] = index[j];
			index[j] = tem;
			k = j;
		}
	}
	
	public IndexHeapClass(int capacity) {
		index = new int[capacity + 1];
		data = new int[capacity + 1];
		count = 0;
	}
	
	public void insert(int k) {
		data[count + 1] = k;
		index[count + 1] = count + 1;
		count++;
		shiftUp(count);
	}
	
	public int exetureMax() {
		int res = data[index[1]];
		//swap index[count] index[1] and count--
		int tem = index[1];
		index[1] = index[count];
		index[count] = tem;
		count--;
		shiftDown(1);
		return res;
	}
	
	public static void main(String[] args) {
		int[] tes = {1,3,5,2,6,4};
		IndexHeapClass heap = new IndexHeapClass(10);
		for (int i : tes) {
			heap.insert(i);
		}
		for (int i = 0; i < 6; i++) {
			int res = heap.exetureMax();
			System.out.println(res);
		}
		
	}
}
