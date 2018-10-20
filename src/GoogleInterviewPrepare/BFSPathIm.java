package GoogleInterviewPrepare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSPathIm {
    SparseGraphIm graph;
    int[] visited;
    int[] from;
    int[] ord;

    BFSPathIm(SparseGraphIm graph) {
        this.graph = graph;
        visited = new int[graph.n];
        from = new int[graph.n];
        //ord: order, record each nodes distance from the start node.
        ord = new int[graph.n];

        for (int i = 0; i < graph.n; i++) {
            from[i] = -1;
            ord[i] = -1;
        }

        /*for (int i = 0; i < graph.n; i++) {
            if (visited[i] != 1)
                bfs(i);
        }*/
        bfs(0);
    }

    public void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        ord[v] = 0;
        while (!queue.isEmpty()) {
            int w = queue.remove();
            System.out.println(w);
            ArrayList<Integer> al = graph.getNodeList(w);
            for (int i : al) {
                if (visited[i] != 1) {
                    queue.add(i);
                    visited[i] = 1;
                    from[i] = w;
                    ord[i] = ord[w] + 1;
                }
            }
        }
    }

    public ArrayList<Integer> getPath(int v) {
        //assert v
        if (visited[v] == 1) {
            Stack<Integer> stack = new Stack<>();
            int p = v;
            while (p != -1) {
                stack.push(p);
                p = from[p];
            }

            ArrayList<Integer> al = new ArrayList<>();
            while (!stack.isEmpty()) {
                al.add(stack.pop());
            }
            return al;
        }
        return null;
    }

    public static void main(String[] args) {
        SparseGraphIm graph = new SparseGraphIm(6,true);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(1,3);
        graph.addEdge(3,4);

        BFSPathIm bfs = new BFSPathIm(graph);
        ArrayList<Integer> al = bfs.getPath(5);
        System.out.println(al);
        int[] res = bfs.ord;
        for (int i : res) {
            System.out.println(i);
        }
    }
}
