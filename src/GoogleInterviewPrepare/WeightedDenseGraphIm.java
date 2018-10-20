package GoogleInterviewPrepare;

import java.util.ArrayList;

class Edge {
    int a;
    int b;
    double weight;

    Edge (int a, int b, double weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

public class WeightedDenseGraphIm {
    //nodes count
    int n;
    //edgeList count
    int m;
    //directed
    boolean directed;
    //use edge to store the node
    Edge[][] edgeList;

    WeightedDenseGraphIm(int capacity, boolean directed) {
        this.n = capacity;
        this.m = 0;
        this.directed = directed;
        edgeList = new Edge[n][n];
    }

    public void addEdge(int v, int w, double weight) {
        if (hasEdge(v,w)) {
            //because weighted graph some times has less weighted edge to add, here we use the smallest weight as the edge
            if (weight < edgeList[v][w].getWeight()) {
                edgeList[v][w] = null;
                m--;
            }
            else
                return;
        }
        if (v != w) {
            edgeList[v][w] = new Edge(v, w, weight);
            if (!directed)
                edgeList[w][v] = new Edge(v, w, weight);
            m++;
        }
    }

    public boolean hasEdge(int v, int w) {
        return edgeList[v][w] != null;
    }

    public ArrayList<Edge> getNodeList(int v) {
        //assert v
        ArrayList<Edge> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (edgeList[v][i] != null)
                al.add(edgeList[v][i]);
        }
        return al;
    }

    public static void main(String[] args) {
        WeightedDenseGraphIm g = new WeightedDenseGraphIm(9, true);
        g.addEdge(0,1, 3);
        g.addEdge(0,1,2);
        g.addEdge(0,2,2);
        g.addEdge(0,5,1);
        g.addEdge(0,6,2);
        g.addEdge(3,5,2);
        g.addEdge(3,4,1);
        g.addEdge(4,5,9);
        g.addEdge(4,6,1);
        g.addEdge(7,8,3);
        for (int i = 0; i < 9; i++) {
            ArrayList<Edge> al = g.getNodeList(i);
            for (Edge ed : al)
                System.out.println("i: " + i + " a: " + ed.a + " b: " + ed.b + " weight: " + ed.getWeight());
        }
    }

}
