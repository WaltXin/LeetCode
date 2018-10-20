package GoogleInterviewPrepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeightedSpareGraphIm {
    int n;
    int m;
    boolean directed;
    Map<Integer, ArrayList<Edge>> adList = new HashMap<>();

    WeightedSpareGraphIm (int capacity, boolean directed) {
        this.n = capacity;
        this.m = 0;
        this.directed = directed;
        for (int i = 0; i < n ; i++) {
            ArrayList<Edge> al = new ArrayList<>();
            adList.put(i, al);
        }
    }

    public void addEdge(int v, int w, int weight) {
        //if has edge, use the less weighted one
        double checkWeight = hasEdge(v, w);
        if (checkWeight != -1) {
            if (weight < checkWeight) {
                //use weight
                ArrayList<Edge> al = adList.get(v);
                for (Edge ed : al)
                    if (ed.b == w) {
                        ed.setWeight(weight);
                        return;
                    }
            } else {
                return;
            }
        }
        ArrayList<Edge> al = adList.get(v);
        al.add(new Edge(v, w, weight));
        if (!directed)
            al.add(new Edge(v, w, weight));
    }

    public double hasEdge(int v, int w) {
        ArrayList<Edge> al = adList.get(v);
        for (Edge ed : al) {
            if (ed.b == w)
                return ed.getWeight();
        }
        return -1;
    }

    public ArrayList<Edge> getNodeList(int v) {
        //assert v
        return adList.get(v);
    }

    public static void main(String[] args) {
        WeightedSpareGraphIm g = new WeightedSpareGraphIm(9, true);
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
