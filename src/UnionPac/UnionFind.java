package UnionPac;

public class UnionFind {

    private int[] id;
    private int count;

    UnionFind(int capacity) {
        count = capacity;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            //every id is different, means non of them is connected
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }

        //change all id[i] equals pid to qid to connect pid and qid value
        //means all values in id[i] (pid == qid)
        for (int i = 0; i < count; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }

    }

    public boolean isConnected(int a, int b) {
        if (find(a) == -1)
            return false;
        return find(a) == find(b);
    }

    public int find(int p) {
        if (p >= 0 && p < count)
            return id[p];
        return -1;
    }

    public static void main(String[] args) {
        UnionFind t = new UnionFind(10);
        t.union(1,3);
        t.union(5,3);
        System.out.println(t.find(5));
        System.out.println(t.isConnected(1,5)); 
    }
}
