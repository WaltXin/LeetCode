package GraphPac;

import java.util.ArrayList;

/**
 * Use Adjacency Matrix implement Dense Graph
 * */
public class DenseGraph {
    //n: nodes count
    private int n;
    //m: edges count
    private int m;
    //direction: directed graph or undirected graph
    private boolean directed;
    //adMatrix: Adjacency Matrix, true means two node connected, false means two node not connected
    int[][] adMatrix;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        adMatrix = new int[n][n];
    }

    //connect node v and node w
    public void addEdge(int v, int w) {
        if (hasEdge(v, w))
            return;

        adMatrix[v][w] = 1;
        if (!directed) {
            adMatrix[w][v] = 1;
        }
        m++;
    }

    public int getNode() {
        return n;
    }

    public int getEdge() {
        return m;
    }

    public ArrayList<Integer> getNodeList(int v) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (adMatrix[v][i] == 1) {
                al.add(i);
            }
        }
        return al;
    }

    public int[][] getAdMatrix() {
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(adMatrix[i][j] + " ");
            }
        }
        return adMatrix;
    }

    public boolean hasEdge(int v, int w) {
        return adMatrix[v][w] == 1;
    }

    public static void main(String[] args) {
        DenseGraph g = new DenseGraph(6,false);
        g.addEdge(0,1);
        g.addEdge(1,3);
        g.getAdMatrix();
        System.out.println(g.getNodeList(1));
    }
}
