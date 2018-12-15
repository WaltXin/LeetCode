package InterviewPrepare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    Node left;
    Node right;
    int val;
    Node(int val) {
        this.val= val;
    }
}


public class TreeIm {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    int size;
    Node root;
    TreeIm () {

    }

    //dfs recursive(pre, in, post)
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void preOrderIte(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack<Node>();
        Node curr = node;
        //stack.add(node);
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.println(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }

    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public void inOrderIte(Node node) {
        Stack<Node> stack = new Stack<Node>();
        Node curr = node;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                //pop the left
                curr = stack.pop();
                System.out.println(curr.val);
                curr = curr.right;
            }
        }
    }

    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    public void postOrderIte(Node node) {
        Stack<Node> stack = new Stack<>();
        Node curr = node;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                //check if we went to right or not, if curr equals stack.peek means never visited node right
                //should visited node.right
                if (!stack.isEmpty() && curr == stack.peek()) {
                    curr = curr.right;
                } else {
                    //curr != stack.peek means we already visited node.right we should out put curr value
                    System.out.println(curr.val);
                    //set null to come here again
                    curr = null;
                }
            }
        }
    }

    public int height(Node node) {
        if (node.left != null && node.right != null) {
            return 1 + Math.max(height(node.left), height(node.right));
        }
        else if (node.left != null) {
            return 1 + height(node.left);
        }
        else if (node.right != null) {
            return 1 + height(node.right);
        }
        else {
            return 0;
        }
    }

    public int heightIte(Node node) {
        if (node == null) return 0;
        int height = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Node curr = queue.remove();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            height++;
        }
        return height;
    }

    //bfs
    public void bfs(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.val);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null){
                queue.add(curr.right);
            }
        }
    }
    //insert
    //remove

    //revert tree
    /**
     * for every node, only swap this nodes Left and Right child
     * */

    public Node revertTree(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        revertTree(node.left);
        revertTree(node.right);

        return node;
    }

    public Node revertTreeIte(Node node) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            Node tem = curr.left;
            curr.left = curr.right;
            curr.right = tem;
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
        return node;
    }


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
        getPath(root.left, res, path);
        getPath(root.right, res, path);
    }

    //check if a tree is balanced tree(each level height should less than 1)
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

    //create a minimum bst
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

    //check if a tree is a binary search tree
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

    public static void main(String[] args) {
        TreeIm tree = new TreeIm();
        Node root = new Node(5);
        Node r1 = new Node(3);
        Node r2 = new Node(7);
        root.left = r1;
        root.right = r2;
        //new TreeIm().preOrder(root);
        //new TreeIm().preOrderIte(root);
        //new TreeIm().inOrderIte(root);
        //new TreeIm().bfs(root);
        //System.out.println("tree height: " + new TreeIm().treeHeight(root));
        //new TreeIm().postOrderIte(root);
        Node noder = new TreeIm().revertTree(root);
        //new TreeIm().revertTreeIte(root);
    }
}
