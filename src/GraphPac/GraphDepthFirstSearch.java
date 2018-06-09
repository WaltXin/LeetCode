package GraphPac;

import java.util.ArrayList;

public class GraphDepthFirstSearch {
    SparseGraph g;
    //visited: if visited value set to 1
    int[] visited;
    //dfs result
    ArrayList<Integer> dfsRes = new ArrayList<Integer>();

    public GraphDepthFirstSearch(SparseGraph g) {
        this.g = g;
        visited = new int[g.getNodesCount()];
        //the reason why need loop all nodes is because sometimes the graph have more than one components
        for (int i = 0; i < g.getNodesCount(); i++) {
            if (visited[i] != 1) {
                dfs(i);
            }
        }

    }

    private void dfs(int w) {
        visited[w] = 1;
        dfsRes.add(w);
        ArrayList<Integer> al = g.getNodeList(w);
        for (int i : al) {
            if (visited[i] != 1) {
                dfs(i);
            }
        }
    }

    public ArrayList<Integer> getDFSSeq() {
        return dfsRes;
    }
}
