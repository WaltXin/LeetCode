package InterviewPrepare;

public class J684_Redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] uf = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            uf[i] = i;
        }
        int[] res = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int u = root(edges[i][0],uf);
            int v = root(edges[i][1],uf);
            if (u == v) {
                //find the same root, redundant
                res[0] = edges[i][0];
                res[1] = edges[i][1];
                break;
            } else {
                uf[u] = v;
            }
        }
        return res;
    }

    public int root(int i, int[] uf) {
        while (uf[i] != i) {
            i = uf[i];
        }
        return i;
    }
}
