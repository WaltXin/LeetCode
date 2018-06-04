package UnionPac;

public class QuickUnionFindWithHeight {
    private int[] id;
    private int[] height;
    private int count;

    QuickUnionFindWithHeight(int capacity) {
        count = capacity;
        id = new int[capacity];
        height = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            id[i] = i;
            //because initial height is 1
            height[i] = 1;
        }
    }

    //quick union height: find two union value's root and union both root, compare with height first
    //because union just one step and find's complexity is only relate with tree's height.
    //Tree's height is less than capacity
    public void quickUnion(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;
        //compare two value's height
        //if two height is same just need add 1 in parent root
        if (height[p] == height[q]) {
            id[pid] = qid;
            height[qid]++;
        } else if (height[p] < height[q]) {
            id[pid] = qid;
        } else {
            id[qid] = pid;
        }

    }

    public int find(int a) {
        if (id[a] == a) {
              //path compression(路径压缩), a -> b -> c ->d -> e become d -> e <- c <- b
              //                                                                 ^
              //                                                                 |
              //                                                                 a
              //find parent's parent
              id[a] = id[id[a]];
              //path compression(路径压缩)
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

    public int height(int a) {
        return height[a];
    }

    public static void main(String[] args) {
        QuickUnionFindWithHeight t = new QuickUnionFindWithHeight(10);
        t.quickUnion(1,3);
        t.quickUnion(5,3);
        t.quickUnion(4,2);
        t.quickUnion(2,6);
        t.quickUnion(2,3);
        System.out.println(t.find(2));
        System.out.println(t.height(2));
    }
}
