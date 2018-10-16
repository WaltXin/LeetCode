package GoogleInterviewPrepare;

public class HeapIm {
    int[] data;
    int count = 0;
    HeapIm(int capacity) {
        data = new int[capacity + 1];
        //count = 1;
    }

    int[] returnArr() {
        return data;
    }

    void insert(int n) {
        data[++count] = n;
        shiftUp(count);
    }

    int remove() {
        int res = data[1];
        shiftDown();
        return res;
    }

    void shiftDown() {
        //put last value in front
        data[1] = data[count];
        count--;
        int k = 1;
        while (2 * k <= count) {
            //initial left child
            int j = 2 * k;
            //compare if right child exist and great than left child
            if (j + 1 <= count && data[j + 1] > data[j]) {
                j = j + 1;
            }
            if (data[k] > data[j]) break;
            int tem = data[k];
            data[k] = data[j];
            data[j] = tem;
        }
    }

    void shiftUp(int m) {
        while (m > 1 && data[m] > data[m / 2]) {
            //swap data[m] with data[m/2]
            int tem = data[m];
            data[m] = data[m / 2];
            data[m / 2] = tem;
            m = m / 2;
        }
    }

    public static void main(String[] args) {
        HeapIm heap = new HeapIm(10);
        heap.insert(62);
        heap.insert(31);
        heap.insert(42);
        heap.insert(16);
        heap.insert(18);
        heap.insert(37);
        heap.insert(26);
        heap.insert(52);
        heap.remove();
        int[] res = heap.returnArr();
        System.out.println(res[0]);
    }
}
