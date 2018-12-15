package InterviewPrepare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class J399_Evaluate_Division_Spanning_Tree {
    class Edges {
        String source;
        String target;
        double weight;
        Edges(String source, String target, double weight) {
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
        Map<String, ArrayList<Edges>> graph = genGraph(equations, values);
        Map<String, ArrayList<Edges>> forest = new HashMap<>();
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

    public void spaningTree(double weight, String curr, String key, Map<String, ArrayList<Edges>> graph, Map<String, Edges> forest) {
        if (forest.containsKey(curr))  {
            return;
        }
        forest.put(curr, new Edges(key, curr, weight));
        ArrayList<Edges> al = graph.get(curr);
        if (al != null) {
            for (Edges e : al) {
                spaningTree(weight * e.weight, e.target, key, graph, forest);
            }
        }
    }

    public Result getQuotient(String curr, String target, HashSet<String> visited, Map<String, ArrayList<Edges>> graph) {
        visited.add(curr);
        ArrayList<Edges> successors = graph.get(curr);
        if (successors != null) {
            for (Edges successor : successors) {
                if (successor.target == target) {
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

    private void addEdge(Map<String, ArrayList<Edges>> graph, String source, String target, double value) {
        ArrayList<Edges> edges = graph.computeIfAbsent(source, k -> new ArrayList<>());
        /*ArrayList<Edges> edges = graph.get(source);
        if (edges == null) {
            edges = new ArrayList<>();
            graph.put(source, edges);
        }*/
        edges.add(new Edges(source, target, value));
    }

    public Map<String, ArrayList<Edges>> genGraph(String[][] equations, double[] values) {
        Map<String, ArrayList<Edges>> graph = new HashMap<>();

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