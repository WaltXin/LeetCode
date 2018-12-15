package InterviewPrepare;

import java.util.*;

public class J332_Reconstruct_Itinerary {
    public List<String> findItinerary(String[][] tickets) {
        //Eulerian path
        Map<String, PriorityQueue> graph = transferToAdjancencyList(tickets);
        List<String> res = new ArrayList<String>();
        //dfs
        dfs("JFK", graph, res);
        //reverse list
        Collections.reverse(res);
        return res;
    }

    public void dfs(String curr, Map<String, PriorityQueue> graph, List<String> res) {
        PriorityQueue<String> pq = graph.get(curr);
        if (pq != null) {
            while (!pq.isEmpty()) {
                String successor = pq.poll();
                dfs(successor, graph, res);
            }
        }
        //dfs will go though all edges of curr node, And queue will delete all edges of curr node, so now the curr node must visited and never come back
        res.add(curr);
    }

    public Map<String, PriorityQueue> transferToAdjancencyList(String[][] tickets) {
        Map<String, PriorityQueue> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (map.containsKey(tickets[i][0])) {
                map.get(tickets[i][0]).add(tickets[i][1]);
            } else {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(tickets[i][1]);
                map.put(tickets[i][0], pq);
            }
        }
        return map;
    }
}
