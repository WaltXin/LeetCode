package GoogleInterviewPrepare;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class J230_Kth_Smallest_Element_in_a_BST {

    int count = 0;
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
}