package UnionPac;

public class QuickUnionFind {
    private int[] id;
    private int count; 

    QuickUnionFind(int capacity) {
        count = capacity;
        id = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            id[i] = i;
        }
    }

    //quick union: find two union value's root and union both root
    //because union just one step and find's complexity is only relate with tree's height.
    //Tree's height is less than capacity
    public void quickUnion(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;
        id[pid] = qid;
    }

    public int find(int a) {
        if (id[a] == a) {
            return id[a];
        }
        return find(id[a]);

        //or you can use while loop
        /**
        while (a != id[a])
            a = id[a];
        return a;
        **/
    }

    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) {
        QuickUnionFind t = new QuickUnionFind(10);
        t.quickUnion(1,3);
        t.quickUnion(5,3);
        t.quickUnion(4,1);
        System.out.println(t.find(4));
        System.out.println(t.isConnected(4,3));
    }
}
