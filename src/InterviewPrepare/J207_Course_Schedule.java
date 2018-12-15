package InterviewPrepare;

import java.util.ArrayList;

public class J207_Course_Schedule {
    public enum State {
        PENDING,
        COMPLETE
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = genADJ(numCourses, prerequisites);
        State[] state = new State[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, state, graph)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(int v, State[] state, ArrayList<ArrayList<Integer>> graph) {
        if (state[v] != null)
            return state[v] == State.PENDING;
        state[v] = State.PENDING;
        ArrayList<Integer> successors = graph.get(v);
        if (successors != null) {
            for (int successor : successors) {
                if (hasCycle(successor, state, graph)) {
                    return true;
                }
            }
        }
        state[v] = State.COMPLETE;
        return false;
    }

    public ArrayList<ArrayList<Integer>> genADJ(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<> (numCourses);
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

    public static void main(String[] args) {
        int[][] str = {{0,1},{1,0}};
        System.out.println(new J207_Course_Schedule().canFinish(2, str));

    }
}
