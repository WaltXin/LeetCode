package GraphPac;

import java.util.ArrayList;

public class SparseGraph {
    //n: nodes count
    private int n;
    //m: edges count
    private int m;
    //direction: directed graph or undirected graph
    private boolean directed;
    //adList: Adjacency List, each row values means connected nodes
    private ArrayList<ArrayList<Integer>> adList= new ArrayList<ArrayList<Integer>>();

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> al = new ArrayList<Integer>(i);
            adList.add(al);
        }
    }

    public void addEdge(int v, int w) {
        if (v != w && !hasEdge(v,w)) {
            adList.get(v).add(w);
            if (!directed)
                adList.get(w).add(v);
            m++;
        }
    }

    public boolean hasEdge(int v, int w) {
        return adList.get(v).contains(w);
    }

    public ArrayList<ArrayList<Integer>> getAdList() {
        int i = 0;
        for (ArrayList<Integer> al : adList) {
            System.out.print(i++ + ": ");
            System.out.println(al);
        }
        return adList;
    }

    public ArrayList<Integer> getNodeList(int n) {
        return adList.get(n);
    }

    public int getNodesCount() {
        return n;
    }

    public static void main(String[] args) {
        SparseGraph g = new SparseGraph(7, false);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.getAdList();
        System.out.println(g.getNodeList(0));
    }

}
