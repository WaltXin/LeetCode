package GraphPac;

import java.util.ArrayList;

public class WeightedDenseGraph<Weight> {
    //n: nodes count
    private int n;
    //m: edges count
    private int m;
    //direction: directed graph or undirected graph
    private boolean directed;
    //adMatrix: Adjacency Matrix, true means two node connected, false means two node not connected
    Edge[][] adMatrix;

    public WeightedDenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        adMatrix = new Edge[n][n];
    }

    //connect node v and node w
    public void addEdge(int v, int w, Weight weight) {
        if (hasEdge(v, w))
            return;

        adMatrix[v][w] = new Edge(v, w, weight);
        if (!directed) {
            adMatrix[w][v] = new Edge(v, w, weight);
        }
        m++;
    }

    public int getNode() {
        return n;
    }

    public int getEdge() {
        return m;
    }

    public ArrayList<Edge> getNodeList(int v) {
        ArrayList<Edge> al = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            if (adMatrix[v][i] != null) {
                al.add(adMatrix[v][i]);
            }
        }
        return al;
    }

    public Edge[][] getAdMatrix() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < n; j++) {
                Edge edge = adMatrix[i][j];
                if (edge != null)
                    System.out.print("to:" + edge.getOther(i) + " wt:" + edge.getWeight() + " ");
            }
            System.out.println();
        }
        return adMatrix;
    }

    public boolean hasEdge(int v, int w) {
        return adMatrix[v][w] != null;
    }

    public static void main(String[] args) {
        WeightedDenseGraph<Integer> g = new WeightedDenseGraph<>(9,false);
        g.addEdge(0,1, 3);
        g.addEdge(0,2,2);
        g.addEdge(0,5,1);
        g.addEdge(0,6,2);
        g.addEdge(3,5,2);
        g.addEdge(3,4,1);
        g.addEdge(4,5,9);
        g.addEdge(4,6,1);
        g.addEdge(7,8,3);
        g.getAdMatrix();
    }
}
