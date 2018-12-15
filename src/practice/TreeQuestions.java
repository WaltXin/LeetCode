package practice;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class TreeQuestions {
    //get all path to leaf node
    public void getPath(TreeNode root, ArrayList<String> res, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null || root.right == null) {
            path += root.val;
            res.add(path);
            return;
        }
        path += root.val + "->";
        getPath(root, res, path);
        getPath(root, res, path);
    }

    //check if x tree is balanced tree(each level height should less than 1)
    //for each node, only care about if it's child node's left and right diff <= 1
    /**
     * Time complexity: O(N) Space: O(H) H is tree height
     * */
    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = checkHeight(root.left);
        if (left == -1) {
            return -1;
        }
        left++;
        int right = checkHeight(root.right);
        if (right == -1) {
            return -1;
        }
        right++;

        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
    }

    //create x minimum bst
    public TreeNode minimumBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = minimumBST(array, start, mid - 1);
        n.right = minimumBST(array, mid + 1, end);
        return n;
    }

    //check if x tree is x binary search tree
    int previous = Integer.MIN_VALUE;
    public boolean isBST(TreeNode root) {
        if (root == null) return true;
        //check left
        if(!isBST(root.left)) {
            return false;
        }
        if (root.val <= previous) {
            return false;
        }
        previous = root.val;
        if (!isBST(root.right)) {
            return false;
        }
        return true;
    }

    //invert binary tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
