package InterviewPrepare;

import java.util.PriorityQueue;

public class DijkstraIm {

    public void solution(int source, int target, WeightedEdge[][] adList) {
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(adList.length);
        boolean[] visited = new boolean[adList.length];
        int[] from = new int[adList.length];
        WeightedEdge[] w1 = adList[source];
        for (int i = 0; i < w1.length; i++) {
            pq.add(w1[i]);
        }
        visited[source] = true;
        while (!pq.isEmpty()) {
            WeightedEdge e = pq.poll();
            if (visited[e.End]) {
                continue;
            }
            visited[e.End] = true;
            from[e.End] = e.Start;

            if (e.End == target) {
                //loop to get from path
                int p = target;
                while (p != source) {
                    System.out.println(p);
                    p = from[p];
                }
                System.out.println(source);

                return;
            }

            for (WeightedEdge edge : adList[e.End]) {
                if (!visited[edge.End]) {
                    pq.add(edge);
                }
            }
        }

    }


    public static void main(String[] args) {
        WeightedEdge[][] graph = new WeightedEdge[5][];
        graph[0] = new WeightedEdge[]{
                new WeightedEdge(5, 0, 1),
                new WeightedEdge(2, 0, 2),
                new WeightedEdge(6, 0, 3),
        };
        graph[1] = new WeightedEdge[]{
                new WeightedEdge(1, 1, 4),
        };
        graph[2] = new WeightedEdge[]{
                new WeightedEdge(1, 2, 1),
                new WeightedEdge(3, 2, 3),
                new WeightedEdge(5, 2, 4),
        };
        graph[3] = new WeightedEdge[]{
                new WeightedEdge(2, 3, 4),
        };

        new DijkstraIm().solution(0, 4, graph);
    }
}
    class WeightedEdge implements Comparable<WeightedEdge> {
        public int Weight;
        public int Start;
        public int End;

        public WeightedEdge(int weight, int start, int end) {
            Weight = weight;
            Start = start;
            End = end;
        }

        @Override
        public int compareTo(WeightedEdge o) {
            return Weight - o.Weight;
        }
    }

