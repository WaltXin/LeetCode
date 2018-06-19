package GraphPac;

import java.util.ArrayList;

public class WeightedSparseGraph<Weight> {
    //n: nodes count
    private int n;
    //m: edges count
    private int m;
    //direction: directed graph or undirected graph
    private boolean directed;
    //adList: Adjacency List, each row values means connected nodes
    private ArrayList<ArrayList<Edge>> adList= new ArrayList<ArrayList<Edge>>();

    public WeightedSparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            ArrayList<Edge> al = new ArrayList<Edge>(i);
            adList.add(al);
        }
    }

    public void addEdge(int v, int w, Weight weight) {



        if (!hasEdge(v,w) && v != w) {
            adList.get(v).add(new Edge(v, w, weight));
            if (!directed)
                adList.get(w).add(new Edge(v, w, weight));
            m++;
        }
    }

    public boolean hasEdge(int v, int w) {
        ArrayList<Edge> tal = adList.get(v);
        for (Edge e : tal) {
            if (e.getOther(v) == w) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<ArrayList<Edge>> getAdList() {
        int i = 0;
        for (ArrayList<Edge> al : adList) {
            System.out.print(i + ": ");
            for (Edge edge : al) {
                int dis = edge.getOther(i);
                System.out.print("to " + dis + " wt:" + edge.weight + " | ");
            }
            i++;
            System.out.println();
        }
        return adList;
    }

    public ArrayList<Edge> getNodeList(int n) {
        return adList.get(n);
    }

    public int getNodesCount() {
        return n;
    }

    public static void main (String[] args) {
        WeightedSparseGraph<Integer> g = new WeightedSparseGraph(9, false);
        g.addEdge(0,1, 3);
        g.addEdge(0,2,2);
        g.addEdge(0,5,1);
        g.addEdge(0,6,2);
        g.addEdge(3,5,2);
        g.addEdge(3,4,1);
        g.addEdge(4,5,9);
        g.addEdge(4,6,1);
        g.addEdge(7,8,3);
        g.getAdList();
    }
}
