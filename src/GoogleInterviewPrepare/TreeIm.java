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
        new TreeIm().postOrderIte(root);
        //new TreeIm().revertTree(root);
        new TreeIm().revertTreeIte(root);
    }
}
