package InterviewPrepare;


import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class J230_Kth_Smallest_Element_in_a_BST {

    int count = 0;
    boolean result = true;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        return recursiveSolution(root, k).val;
    }

    public TreeNode recursiveSolution(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = recursiveSolution(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return recursiveSolution(root.right, k);
    }

    public boolean isBalance(TreeNode root) {
        dfs(root);
        return result;
    }


    public int dfs(TreeNode root) {
        if (root == null) return -1;

        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            result = false;
            return 0;
        }
        return Math.max(left,right);
    }

    public void dfs1(TreeNode root, String path, ArrayList<String> res) {
        if (root == null) return;
        //leaf node
        if (root.left == null || root.right == null) {
            path += root.val;
            res.add(path);
        } else {
            path += root.val + "->";
            dfs1(root.left, path, res);
            dfs1(root.right, path, res);
        }
    }

}