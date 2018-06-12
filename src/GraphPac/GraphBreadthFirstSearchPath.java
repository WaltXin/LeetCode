package GraphPac;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class GraphBreadthFirstSearchPath {
    SparseGraph g;
    int[] visited;
    int[] from;
    //distance from search node
    int[] distance;


    public GraphBreadthFirstSearchPath(SparseGraph g, int v) {
        this.g = g;
        visited = new int[g.getNodesCount()];
        from = new int[g.getNodesCount()];
        distance = new int[g.getNodesCount()];
        for (int i = 0; i < g.getNodesCount(); i++) {
            from[i] = -1;
            distance[i] = -1;
        }
        bfs(v);
    }

    private void bfs(int w) {
        visited[w] = 1;
        Deque<Integer> queue = new LinkedList<Integer>();
        queue.add(w);
        distance[w] = 0;
        while (!queue.isEmpty()) {
            int m = queue.remove();
            ArrayList<Integer> al = g.getNodeList(m);
            for (int i : al) {
                if (visited[i] != 1) {
                    queue.add(i);
                    //if added in queue, it will be visited
                    visited[i] = 1;
                    //record previous node
                    from[i] = m;
                    distance[i] = distance[m] + 1;
                }
            }

        }
    }

    public boolean hasPath(int w) {
        return visited[w] == 1;
    }

    private void path(int w, ArrayList<Integer> al) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        while (!stack.isEmpty()) {
            al.add(stack.poll());
        }
    }

    public void showPath(int w) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        path(w, al);
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i));
            if (i == al.size() - 1) break;
            System.out.print(" -> ");
        }
        System.out.print("  Distance to " + w + " is: " + getDistance(w));
        System.out.println();
    }

    public int getDistance(int w) {
        return distance[w];
    }
}
