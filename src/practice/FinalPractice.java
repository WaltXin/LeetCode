package practice;

import java.util.*;


public class FinalPractice {
    //get maximum region of 1
    int currCount = 0;
    public int maxRegionOfOne(int[][] arr) {
        int max = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                currCount = 0;
                getRegion(arr, row, column);
                max = Math.max(max, currCount);
            }
        }
        return max;
    }

    public void getRegion(int[][] arr, int row, int column) {
        if (row < 0 || row > arr.length - 1 || column < 0 || column > arr[row].length - 1)
            return;
        if (arr[row][column] == 0) return;
        currCount++;
        arr[row][column] = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                getRegion(arr, r, c);
            }
        }
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, root, null);
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);
        set.add(target.val);
        int k = 0;
        //bfs
        while (!queue.isEmpty() && k <= K) {
            int s = queue.size();
            while (s > 0) {
                int curr = queue.remove();
                if (k == K) {
                    res.add(curr);
                }
                List<Integer> neibourghs = graph.get(curr);
                if (neibourghs != null) {
                    for (int nei : neibourghs) {
                        if (!set.contains(nei)) {
                            queue.add(nei);
                            set.add(nei);
                        }
                    }
                }
                s--;
            }
            k++;
        }
        return res;

    }
    public void buildGraph(Map<Integer, List<Integer>> graph, TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!graph.containsKey(node.val)) {
            graph.put(node.val, new ArrayList<>());
            if (parent != null) {
                graph.get(node.val).add(parent.val);
                graph.get(parent.val).add(node.val);
            }
            buildGraph(graph, node.left, node);
            buildGraph(graph, node.right, node);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,1,0,0},
                       {1,0,0,0,1},
                       {1,1,1,1,0},
                       {0,0,1,0,1},
                       {0,1,1,0,0}};

        TreeNode r3 = new TreeNode(3);
        TreeNode r5 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);
        TreeNode r6 = new TreeNode(6);
        TreeNode r2 = new TreeNode(2);
        TreeNode r0 = new TreeNode(0);
        TreeNode r8 = new TreeNode(8);
        TreeNode r7 = new TreeNode(7);
        TreeNode r4 = new TreeNode(4);
        r3.left = r5;
        r3.right = r1;
        r5.left = r6;
        r5.right = r2;
        r1.left = r0;
        r1.right = r8;
        r2.left = r7;
        r2.right = r4;

        new FinalPractice().distanceK(r3, r5, 2);


        //System.out.println(new FinalPractice().maxRegionOfOne(arr));

    }

}
