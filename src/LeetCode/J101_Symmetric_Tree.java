package LeetCode;

public class J101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(2);
        TreeNode r4 = new TreeNode(3);
        root.left = r1;
        r1.left = r2;
        root.right = r4;
        r4.left = r3;
        System.out.println(new J101_Symmetric_Tree().isSymmetric(root));
    }
}
