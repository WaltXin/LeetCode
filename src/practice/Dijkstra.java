package practice;

import java.util.PriorityQueue;

public class Dijkstra {


    public void solution(int source, int target, WeightedEdge[][] adList) {
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[adList.length];
        int[] from = new int[adList.length];
        WeightedEdge[] w1 = adList[source];
        for (int i = 0; i < w1.length; i++) {
            pq.add(w1[i]);
        }
        visited[source] = true;
        while(!pq.isEmpty()) {
            WeightedEdge edge = pq.poll();
            if (visited[edge.end]) {
                continue;
            }
            visited[edge.end] = true;
            from[edge.end] = edge.start;
            if (edge.end == target) {
                int p = target;
                while (p != source) {
                    p = from[p];
                }
                return;
            }
            for (WeightedEdge ed : adList[edge.end]) {
                if (!visited[ed.end]) {
                    pq.add(ed);
                }
            }
        }
    }

    class WeightedEdge implements Comparable<WeightedEdge> {
        public int weight;
        public int start;
        public int end;

        public WeightedEdge(int weight, int start, int end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(WeightedEdge o) {
            return weight - o.weight;
        }
    }
}
