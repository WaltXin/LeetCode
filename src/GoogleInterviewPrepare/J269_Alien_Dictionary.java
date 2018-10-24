package GoogleInterviewPrepare;

import java.util.*;

public class J269_Alien_Dictionary {
    public enum State {
        PENDING,
        COMPLETE
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = genADJList(words);
        if (graph.size() == 0) return String.valueOf(words[0].charAt(0));
        StringBuilder res = new StringBuilder();
        Map<Character, State> state = new HashMap<>();
        for (Character key : graph.keySet()) {
            if (hasCycle(key, state, graph, res)) {
                return "";
            }
        }
        res.reverse();
        return res.toString();
    }

    public boolean hasCycle(Character key, Map<Character, State> state, Map<Character, Set<Character>> graph,StringBuilder res) {
        if (state.get(key) != null) {
            //means visited
            return state.get(key) == State.PENDING;
        }
        state.put(key, State.PENDING);
        Set<Character> successors = graph.get(key);
        if (successors != null) {
            for (Character successor : successors) {
                if (hasCycle(successor, state, graph, res)) {
                    return true;
                }
            }
        }
        state.put(key, State.COMPLETE);
        res.append(key);
        return false;
    }

    public Map<Character, Set<Character>> genADJList(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                graph.put(words[i].charAt(j), null);
            }
        }
        //loop find first diff char
        for (int i = 1; i < words.length; i++) {
            String compare = words[i - 1];
            String curr = words[i];
            int size = Math.min(compare.length(), curr.length());
            for (int j = 0; j < size; j++) {
                char ch = compare.charAt(j);
                if (ch != curr.charAt(j)) {
                    Set<Character> su = graph.computeIfAbsent(ch, k -> new HashSet<>());
                    su.add(curr.charAt(j));
                    break;
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        String[] str= {"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        String[] s1 = {"zx","zy"};
        new J269_Alien_Dictionary().alienOrder(s1);
    }
}