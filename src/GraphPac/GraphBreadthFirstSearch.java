package GraphPac;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class GraphBreadthFirstSearch {
    SparseGraph g;
    //visited: if visited value set to 1
    int[] visited;
    //bfs result
    ArrayList<Integer> bfsRes = new ArrayList<Integer>();

    public GraphBreadthFirstSearch(SparseGraph g) {
        this.g = g;
        visited = new int[g.getNodesCount()];
        //the reason why need loop all nodes is because sometimes the graph have more than one components
        for (int i = 0; i < g.getNodesCount(); i++) {
            if (visited[i] != 1) {
                bfs(i);
            }
        }
    }

    private void bfs(int w) {
        visited[w] = 1;
        Deque<Integer> queue = new LinkedList<Integer>();
        queue.add(w);
        while (!queue.isEmpty()) {
            int m = queue.remove();
            bfsRes.add(m);
            ArrayList<Integer> al = g.getNodeList(m);
            for (int i : al) {
                if (visited[i] != 1) {
                    queue.add(i);
                    //if added in queue, it will be visited
                    visited[i] = 1;
                }
            }

        }
    }

    public ArrayList<Integer> getBFSSeq() {
        return bfsRes;
    }
}
