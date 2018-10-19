package GoogleInterviewPrepare;

import java.util.ArrayList;

public class ComponentIm {
    SparseGraphIm graph;
    //node count
    int capacity = 0;
    //if not visited value is 0, visited is 1
    int[] visited;
    //component count
    int componentCount;
    //check if connected
    int[] connected;

    ComponentIm (SparseGraphIm graph) {
        this.graph = graph;
        this.capacity = graph.n;
        visited = new int[capacity];
        connected = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            connected[i] = -1;
        }

        for (int i = 0; i < capacity; i++) {
            if (visited[i] != 1) {
                dfs(i);
                componentCount++;
            }
        }
    }

    private void dfs(int v) {
       visited[v] = 1;
       connected[v] = componentCount;
       ArrayList<Integer> al = graph.getNodeList(v);
       for (int i : al) {
           if (visited[i] != 1)
               dfs(i);
       }
    }

    public boolean isConnected(int v, int w) {
        //check validation
        return (connected[v] == connected[w]) && connected[v] != -1;
    }

    public static void main(String[] args) {
        SparseGraphIm graph = new SparseGraphIm(6,false);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        ComponentIm component = new ComponentIm(graph);
        System.out.println(component.isConnected(0,4));
        System.out.println(component.componentCount);
    }
}
