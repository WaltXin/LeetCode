package GraphPac;

import java.util.ArrayList;


/**
 * Component: 联通分量
 * */
public class Component {
    private SparseGraph g;
    //check node is visited or not
    private int[] visted;
    private int[] connected;
    private int ccount = 0;

    public Component(SparseGraph g) {
        this.g = g;
        int nodeNum = g.getNodesCount();
        visted = new int[nodeNum];
        connected = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            connected[i] = -1;
        }

        for (int i = 0; i < nodeNum; i++) {
            if (visted[i] != 1) {
                dfsGraph(i);
                ccount++;
            }
        }
    }

    private void dfsGraph(int v) {
        visted[v] = 1;
        connected[v] = ccount;
        ArrayList<Integer> al = g.getNodeList(v);
        for (int i : al) {
            if (visted[i] != 1) {
                dfsGraph(i);
            }
        }
    }

    public boolean isConnected(int v, int w) {
        return connected[v] == connected[w];
    }

    public int count() {
        return ccount;
    }
}
