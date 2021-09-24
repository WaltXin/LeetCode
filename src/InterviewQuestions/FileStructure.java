package InterviewQuestions;

import java.util.*;

/**
 * Company: Dropbox
 *
 * A -- B -- D (access)
 *            -- E
 *            -- F
 *
 *    - C -- G
 *            -- H(access)
 *
 * In this example, D and H has access, if root has access, its children will have access, so E and F has access
 *
 *
 * Lesson learned: don't use BFS for any dfs structure, dfs will make your life way easier
 * */


public class FileStructure {
    static class Node {
        String name;
        List<Node> childs;
        public Node (String name) {
            this.name = name;
            childs = new ArrayList<>();
        }
    }
    public static boolean hasAccess(Node root, String s, Set<String> Access) {
        //use dfs and bfs
        return dfs(root, false, s, Access);
    }

    private static boolean dfs(Node root, boolean hasAccess, String s, Set<String> Access) {
        if (root.name.equals(s)) {
            return hasAccess ? true : false;
        }

        if (Access.contains(root.name))
            hasAccess = true;

        boolean valid = false;
        for (Node child : root.childs) {
            valid = valid ||dfs(child, hasAccess, s, Access);
        }
        return valid;
    }

    public static void main(String[] args) {
        Node root = new Node("A");
        Node nodeB = new Node("B");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeC = new Node("C");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");

        root.childs = Arrays.asList(nodeB, nodeC);
        nodeB.childs = Arrays.asList(nodeD);
        nodeD.childs = Arrays.asList(nodeE, nodeF);
        nodeC.childs = Arrays.asList(nodeG);
        nodeG.childs = Arrays.asList(nodeH);

        Set<String> access = new HashSet<>();
        access.addAll(Arrays.asList("D", "H"));
        System.out.println(hasAccess(root, "F", access));
        System.out.println(hasAccess(root, "B", access));
    }
}
