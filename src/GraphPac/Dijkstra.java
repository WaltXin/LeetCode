package GraphPac;

import java.util.*;

/**
 * paths
 * [a, b, weight]
 * find the shortest path from src to dst
 * */

public class Dijkstra {
    public List<Integer> getShortestPath(int[][] paths, int src, int dst) {
        List<Integer> res = new ArrayList<>();
        //key: node value: {node, weight}
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] path : paths) {
            graph.putIfAbsent(path[0], new ArrayList<>());
            graph.putIfAbsent(path[1], new ArrayList<>());
            graph.get(path[0]).add(new int[]{path[1], path[2]});
            graph.get(path[1]).add(new int[]{path[0], path[2]});
        }
        //key: currNode value: {from previous node(shortest), weight}
        Map<Integer, int[]> from = new HashMap<>();

        //{src, weight}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int currPos = curr[0], weight = curr[1];
            if (currPos == dst) {
                System.out.println("total weight: " + weight);
                break;
            }
            for (int[] next : graph.get(currPos)) {
                int nextPos = next[0], nextWeight = next[1];
                if (!from.containsKey(nextPos) || weight + nextWeight < from.get(nextPos)[1]) {
                    from.put(nextPos, new int[]{currPos, weight + nextWeight});
                    pq.add(new int[]{nextPos, weight + nextWeight});
                }
            }
        }

        if (!from.containsKey(dst))
            return null;

        //find path from dst to src with from map
        while (dst != src) {
            res.add(dst);
            dst = from.get(dst)[0];
        }
        res.add(src);

        return res;
    }

    public static void main(String[] args) {
        int[][] paths = {{0, 1, 5}, {0, 2, 2}, {0, 3, 6}, {2, 1, 1}, {2, 3, 3}, {2, 4, 5},
                {1, 4, 1}, {3, 4, 2}};
        List<Integer> res = new Dijkstra().getShortestPath(paths, 0, 3);
        System.out.println(res);
    }
}
