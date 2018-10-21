package GoogleInterviewPrepare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class mst {
    WeightedSpareGraphIm graph;
    PriorityQueue<Edge> pq;
    boolean marked[];
    ArrayList<Edge> mst = new ArrayList<>();
    double mstWeight = 0;

    mst(WeightedSpareGraphIm graph) {
        this.graph = graph;
        pq = new PriorityQueue<Edge>(graph.n, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return (o1.weight - o2.weight > 0) ? 1 : -1;
            }
        });
        marked = new boolean[graph.n];

        visit(0);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (marked[e.a] != marked[e.b]) {
                //crossing edge
                mst.add(e);
            } else {
                continue;
            }
            if (!marked[e.a])
                visit(e.a);
            else
                visit(e.b);
        }

        mstWeight = mst.get(0).weight;
        for (int i = 1; i < mst.size(); i++) {
            mstWeight += mst.get(i).weight;
        }
    }
    //put one node and mark as red
    public void visit(int v) {
        if (marked[v]) return;
        marked[v] = true;
        ArrayList<Edge> edgeList = graph.getNodeList(v);
        for (Edge e : edgeList) {
            if (marked[v] != marked[e.b]) {
                //in different group
                pq.add(e);
            }
        }
    }

    public ArrayList<Edge> getMst() {
        return mst;
    }

    public double getMstWeight() {
        return mstWeight;
    }

    public static void main(String[] args) {
        WeightedSpareGraphIm g = new WeightedSpareGraphIm(8,false);
        g.addEdge(0,2, 0.26);
        g.addEdge(0,4, 0.38);
        g.addEdge(0,6, 0.58);
        g.addEdge(0,7, 0.16);
        g.addEdge(1,2, 0.36);
        g.addEdge(1,3, 0.29);
        g.addEdge(1,5, 0.32);
        g.addEdge(1,7, 0.19);

        g.addEdge(2,3, 0.17);
        g.addEdge(2,6, 0.40);
        g.addEdge(2,7, 0.34);
        g.addEdge(3,6, 0.52);
        g.addEdge(4,5, 0.35);
        g.addEdge(4,6, 0.93);
        g.addEdge(4,7, 0.37);
        g.addEdge(5,7, 0.28);

        mst ms = new mst(g);
        ArrayList<Edge> res = ms.getMst();
        for (Edge e : res)
            System.out.println(" " + " a: " + e.a + " b: " + e.b + " weight: " + e.weight);
        System.out.println(ms.mstWeight);
    }

}
