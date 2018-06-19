package GraphPac;

import java.util.Random;

public class MinHeap<T extends Comparable<T>> {
    int capacity;
    T[] HeapTree;

    int count = 0;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        HeapTree = (T[])new Comparable[capacity];
    }

    private void ShiftUp(int k) {
        while (k > 1 && HeapTree[k].compareTo(HeapTree[k/2]) < 0) {
            T tem = HeapTree[k];
            HeapTree[k] = HeapTree[k/2];
            HeapTree[k/2] = tem;
            k = k/2;
        }
    }

    private void ShiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && HeapTree[j + 1].compareTo(HeapTree[j]) < 0) {
                j ++;
            }
            if (HeapTree[k].compareTo(HeapTree[j]) < 0) {
                break;
            }
            T tem = HeapTree[k];
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

    public void InsertHeapTree(T item) {

        if (count + 1 < capacity) {
            HeapTree[count + 1] = item;
            count ++;
            ShiftUp(count);
        }
    }

    public T DeleteFirstNode() {
        if (count > 1) {
            T res = HeapTree[1];
            //Swap head node with last node
            T tem = HeapTree[count];
            HeapTree[count] = HeapTree[1];
            HeapTree[1] = tem;
            count --;
            ShiftDown(1);
            return res;
        } else {
            return null;
        }
    }

    public T[] Tree() {
        return HeapTree;
    }

    /*
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<Integer>(25);
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int value = rand.nextInt(40);
            heap.InsertHeapTree(value);
        }
        //T[] result;
       // int[] result;
        int[] result = heap.Tree();
        for (int i:result) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i <= 25; i++) {
            System.out.println(heap.DeleteFirstNode());
        }
    }
    */
}
