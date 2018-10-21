package GoogleInterviewPrepare;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapIm {
    PriorityQueue pe = new PriorityQueue();
    HeapIm () {
        int a = 9;
        int b = 10;
        int c = 8;
        pe.add(a);
        pe.add(b);
        pe.add(c);
        System.out.println(pe.poll());

        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        maxHeap.add(a);
        maxHeap.add(b);
        System.out.println(maxHeap.poll());
    }

    public static void main(String[] args) {
        HeapIm heap = new HeapIm();
    }


}
