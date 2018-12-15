package InterviewPrepare;

import java.util.*;

public class J210_Course_Schedule_II {
    public enum State {
        PENDING,
        COMPLETE
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = genADJ(numCourses, prerequisites);
        ArrayList<Integer> res = new ArrayList<>();
        State[] state = new State[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, state, graph, res)) {
                return new int[0];
            }
        }
        //Collections.reverse(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public boolean hasCycle(int v, State[] state, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> res) {
        if (state[v] != null)
            return state[v] == State.PENDING;
        state[v] = State.PENDING;
        ArrayList<Integer> successors = graph.get(v);
        if (successors != null) {
            for (int successor : successors) {
                if (hasCycle(successor, state, graph, res)) {
                    return true;
                }
            }
        }
        state[v] = State.COMPLETE;
        res.add(v);
        return false;
    }

    public ArrayList<ArrayList<Integer>> genADJ(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>> (numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(null);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> adj = graph.get(prerequisites[i][0]);
            if (adj == null) {
                adj = new ArrayList<>();
                graph.set(prerequisites[i][0], adj);
            }
            adj.add(prerequisites[i][1]);
        }
        return graph;
    }

}