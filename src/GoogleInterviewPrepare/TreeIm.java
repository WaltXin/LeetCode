package GoogleInterviewPrepare;

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
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                System.out.println(curr.val);
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
        while (!stack.isEmpty() || curr != null) {
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



    }

    private int height(Node node) {
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

    private int heightIte(Node node) {
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
    //tree height recursive
    public int treeHeight(Node node) {
        if (node == null) return -1;
        int height = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            height++;
        }
        return height;
    }
    //tree height iterative

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
        new TreeIm().bfs(root);
        System.out.println("tree height: " + new TreeIm().treeHeight(root));
    }
}
