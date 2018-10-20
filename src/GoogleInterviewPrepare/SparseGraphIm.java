package GoogleInterviewPrepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SparseGraphIm {
    //nodes count
    int n;
    //edgeList count
    int m;
    //directed
    boolean directed;
    //graph
    Map<Integer, ArrayList<Integer>> adList = new HashMap<>();

    public SparseGraphIm(int capacity, boolean directed) {
        this.n = capacity;
        this.m = 0;
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            adList.put(i, al);
        }
    }

    //add edge for v, w
    public void addEdge(int v, int w) {
        if (v != w && !hasEdge(v, w)) {
            adList.get(v).add(w);
            if (!directed)
                adList.get(w).add(v);
        }
    }

    public boolean hasEdge(int v, int w) {
        return adList.get(v).contains(w);
    }

    public ArrayList<Integer> getNodeList(int node) {
        if (node < 0 || node >= n) return null;
        return adList.get(node);
    }
}
