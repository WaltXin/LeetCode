package GraphPac;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class GraphDepthFirstSearchPath {
    SparseGraph g;
    //visited: if visited value set to 1
    int[] visited;
    //dfs path result
    ArrayList<Integer> dfsRes = new ArrayList<Integer>();
    //from: record the nodes previous node, it will build a path when back tracking this array
    int[] from;

    public GraphDepthFirstSearchPath(SparseGraph g, int v) {
        this.g = g;
        visited = new int[g.getNodesCount()];
        from = new int[g.getNodesCount()];

        for (int i = 0; i < g.getNodesCount(); i++) {
            from[i] = -1;
        }

        dfs(v);

    }

    public void dfs(int w) {
        visited[w] = 1;
        ArrayList<Integer> al = g.getNodeList(w);
        for (int i : al) {
            if (visited[i] != 1) {
                dfs(i);
                //record previous node
                from[i] = w;
            }
        }
    }

    //if has path, it must be visited
    public boolean hasPath(int w) {
        return visited[w] == 1;
    }

    //path from v -> w, because it start from v, so we back tracking w by "from" array
    public void path(int w, ArrayList<Integer> al) {
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
        if (!hasPath(w)) return;
        ArrayList<Integer> al = new ArrayList<Integer>();
        path(w,al);
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i));
            if (i == al.size() - 1) break;
            System.out.print(" -> ");
        }
        System.out.println();
    }
}
