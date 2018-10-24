package GoogleInterviewPrepare;

import org.junit.Test;

import java.util.*;

public class J399_Evaluate_Division {
    class Edge {
        String source;
        String target;
        double weight;
        Edge(String source, String target, double weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    class Result {
        boolean ok;
        double result;

        Result(boolean ok, double result) {
            this.ok = ok;
            this.result = result;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<Edge>> graph = genGraph(equations, values);
        double[] res = new double[queries.length];
        HashSet<String> visited = new HashSet<>();
        //dfs to get queries
        for (int i = 0; i < queries.length; i++) {
            if (!graph.containsKey(queries[i][0])) {
                res[i] = -1;
                continue;
            }
            visited.clear();
            Result r = getQuotient(queries[i][0], queries[i][1], visited, graph);
            if (r.ok) {
                res[i] = r.result;
            }else {
                res[i] = -1.0;
            }
        }
        return res;
    }

    public Result getQuotient(String curr, String target, HashSet<String> visited, Map<String, ArrayList<Edge>> graph) {
        visited.add(curr);
        ArrayList<Edge> successors = graph.get(curr);
        if (successors != null) {
            for (Edge successor : successors) {
                if (successor.target.equals(target)) {
                    return new Result(true, successor.weight);
                }
                if (!visited.contains(successor.target)) {
                    Result res = getQuotient(successor.target, target, visited, graph);
                    if (res.ok) {
                        return new Result(true, res.result * successor.weight);
                    }
                }
            }
        }
        return new Result(false, 0);
    }

    private void addEdge(Map<String, ArrayList<Edge>> graph, String source, String target, double value) {
        ArrayList<Edge> edges = graph.computeIfAbsent(source, k -> new ArrayList<>());
        /*ArrayList<Edges> edges = graph.get(source);
        if (edges == null) {
            edges = new ArrayList<>();
            graph.put(source, edges);
        }*/

        edges.add(new Edge(source, target, value));
    }

    public Map<String, ArrayList<Edge>> genGraph(String[][] equations, double[] values) {
        Map<String, ArrayList<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String source = equations[i][0];
            String target = equations[i][1];
            double value = values[i];

            addEdge(graph, source, target, value);

            if (value != 0) {
                addEdge(graph, target, source, 1 / value);
            }
        }

        return graph;
    }

    @Test
    public void test() {
        String[][] eq = new String[2][];
        eq[0] = new String[]{"a", "b"};
        eq[1] = new String[]{"b", "c"};
        double[] values = new double[] {2.0, 3.0};
        String[][] q = new String[5][];
        q[0] = new String[]{"a", "c"};
        q[1] = new String[]{"b", "a"};
        q[2] = new String[]{"a", "e"};
        q[3] = new String[]{"a", "a"};
        q[4] = new String[]{"x", "x"};
        double[] res = new J399_Evaluate_Division().calcEquation(eq, values, q);
    }
}

