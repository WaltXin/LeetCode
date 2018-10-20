package GoogleInterviewPrepare;


import java.util.ArrayList;
import java.util.Stack;

public class DFSPathIm {
    SparseGraphIm graph;
    int[] visited;
    int[] from;
    DFSPathIm(SparseGraphIm graph) {
        this.graph = graph;
        visited = new int[graph.n];
        from = new int[graph.n];
        for (int i = 0; i < graph.n; i++) {
            from[i] = -1;
        }
    }

    public void dfsPath(int v) {
        if (visited[v] != 1)
            dfs(v);
    }

    public void dfs(int v) {
        visited[v] = 1;
        ArrayList<Integer> al = graph.getNodeList(v);
        for (int i : al) {
            if (visited[i] != 1) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    public ArrayList<Integer> getPath(int v) {
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
        graph.addEdge(3,4);

        DFSPathIm path = new DFSPathIm(graph);
        path.dfsPath(0);
        ArrayList<Integer> al = path.getPath(5);
        System.out.println(al);
    }
}
