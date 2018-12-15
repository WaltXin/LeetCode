package InterviewPrepare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GraphConclusion {
    //UnionFind
    //Dijkstra
    //Cycle detection and topological sort (DFS) && BFS
    //Euler path

    /**
     * Union Find
     *
    //J547_Friend_Circles && J684_Redundant_Connection

     in the init of uf, let array uf point to itself
     Map<Integer, Integer> -> int[] If integer in a very small range
     Map<String, String>

     //Key steps: uf is unionFind array store it's parent
        uf[root(j,uf)] = root(i,uf);

        public int root(int i, int[] uf) {
            while (uf[i] != i) {
                i = uf[i];
            }
            return i;
        }
     */

    /**
     * BFS -- diameter
     *
     * queue && visited
     * */
    public void solution(WeightedSpareGraphIm graph) {
        boolean[] visited = new boolean[graph.n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(k -> k.weight));

        pq.add(new Edge(0,1, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            ArrayList<Edge> adjList = graph.getNodeList(edge.a);
            if (adjList != null) {
                for (Edge ed : adjList) {
                    if (!visited[ed.b]) {
                        pq.add(ed);
                        visited[ed.b] = true;
                    }
                }
            }
        }
    }

    /**
     * DFS
     * visited
     * */
    public void dfsSolution(WeightedSpareGraphIm graph) {
        boolean[] visited = new boolean[graph.n];
        dfs(0, visited, graph);
    }

    public void dfs(int v, boolean[] visited, WeightedSpareGraphIm graph) {
        visited[v] = true;
        ArrayList<Edge> adjList = graph.getNodeList(v);
        if (adjList != null) {
            for (Edge ed : adjList) {
                if (!visited[ed.b]) {
                    dfs(ed.b, visited, graph);
                }
            }
        }
    }

    /**
     * Dijkstra
     *
     * DijkstraIm class
     * From unvisited node, find(BFS)
     * */
    public void Dijkstra(WeightedSpareGraphIm graph, int source, int target) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.n, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight > o2.weight ? 1 : -1;
            }
        });
        boolean[] visited = new boolean[graph.n];
        pq.add(new Edge(0, 0, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            al.add(e.b);
            if (e.b == target) {
                //find solution
                break;
            }
            ArrayList<Edge> adjList = graph.getNodeList(e.b);
            if (adjList != null) {
                for (Edge edge : adjList) {
                    if (!visited[edge.b]) {
                        visited[edge.b] = true;
                        pq.add(e);
                    }
                }
            }

        }
    }

    /**
     * Cycle detection and topological sort (DFS)
     * Define State[Pending, COMPLETE]
     *
     * public enum State{
     *     PENDING,
     *     COMPLETE
     * }
     *
     * Core code
     *
     * public boolean hasCycle(int v, State[] state, ArrayList<ArrayList<Integer>> graph) {
     *         if (state[v] != null)
     *             return state[v] == State.PENDING;
     *         state[v] = State.PENDING;
     *         ArrayList<Integer> successors = graph.get(v);
     *         if (successors != null) {
     *             for (int successor : successors) {
     *                 if (hasCycle(successor, state, graph)) {
     *                     return true;
     *                 }
     *             }
     *         }
     *         state[v] = State.COMPLETE;
     *         //TOPOLOGICAL SORT POSITION
     *         //after v being complete add in sort list
     *         return false;
     *     }
     *
     *
     * BFS: record every node's in_degree, queue only add node that in_degree is 0
     * If cannot find and not looped all node yet, than return false;
     *
     * */


    /**
     * Euler path J332_Reconstruct_Itinerary
     *(DFS) but when doing dfs, Using Queue(PriorityQueue) because one edge can only travel once
     *After DFS loop, you can add the node in because all adjacency list being visited
     * Don't need visited[] because queue will poll all edges
     * Core code:
     *  public void dfs(String curr, Map<String, PriorityQueue> graph, List<String> res) {
     *         PriorityQueue<String> pq = graph.get(curr);
     *         if (pq != null) {
     *             while (!pq.isEmpty()) {
     *                 String successor = pq.poll();
     *                 dfs(successor, graph, res);
     *             }
     *         }
     *
     *         //dfs will go though all edges of curr node, And queue will delete all edges of curr node,
     *         //so now the curr node must visited and never come back
     *         res.add(curr);
     *     }
     * */
}
