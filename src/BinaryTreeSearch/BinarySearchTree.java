package BinaryTreeSearch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Node {
	int key;
	int value;
	Node left;
	Node right;
	//the children number
	int count;
	Node (int key, int value) {
		this.key = key;
		this.value = value;
		this.left = this.right = null;
	}
}

public class BinarySearchTree {
	int size;
	Node root;

	private void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.key);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	private void preOrderTraversal(Node node) {
		if (node == null) return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node tem = stack.pop();
			System.out.println(tem.key);
			if (tem.right != null)
				stack.push(tem.right);
			if (tem.left != null)
				stack.push(tem.left);
		}
	}
	
	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.key);
			inOrder(node.right);
		}
	}
	
	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.key);
		}
	}
	
	private Node insert(Node node, int key, int value) {
		size++;
		if (node == null) {
			node = new Node(key, value);
			node.count = 1;
			return node;
		}
		Node tem = node, prev = node;
		while (tem != null) {
			if (tem.key == key) {
				tem.value = value;
				return node;
			}
			tem.count++;
			if (key > tem.key) {
				prev = tem;
				tem = tem.right;
			} else {
				//key < tem.key
				prev = tem;
				tem = tem.left;
			}
		}
		if (key > prev.key) {
			prev.right = new Node(key,value);
			prev.right.count = 1;
		} else {
			prev.left = new Node(key, value);
			prev.left.count = 1;
		}
		
		return node;
	}
	
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	public void insert(int key, int value) {
		root = insert(root, key, value);
	}
	
	public boolean contains(int key) {
		if (root == null) return false;
		Node tem = root;
		while (tem != null) {
			if (tem.key == key) return true;
			if (key > tem.key) {
				tem = tem.right;
			} else {
				tem = tem.left;
			}
		}
		return false;
	}
	
	//delete the node contains the key
	//if the node does not exist return the original root
	public Node deleteNode(int key) {
		if (root == null) {
			return root;
		}
		//add dummy in case if key = root.key
		Node dummy = new Node(0,0);
		dummy.right = root;
		root = dummy;
		
		//if the delete node is not exist, loop this array, get node++;
		ArrayList<Node> arr = new ArrayList<Node>();
		
		Node tem = root, prev = root;
		while (tem != null) {
			arr.add(tem);
			tem.count--;
			if (key == tem.key) {
				//left or right child doesn't exist, just need to shift up
				if (tem.left == null) {
					if (key > prev.key) {
						prev.right = tem.right;
					} else {
						prev.left = tem.right;
					}
					root = root.right;
					return root;
				} else if (tem.right == null) {
					if (key > prev.key) {
						prev.right = tem.left;
					} else {
						prev.left = tem.left;
					}
					root = root.right;
					return root;
				}
				
				//left and right child all exist
				//find the smallest child from right child
				Node riPrev = tem, lp = tem.right;
				while (lp.left != null) {
					riPrev = lp;
					lp = lp.left;
				}
				//delete the lp's parent node
				if (lp.key == riPrev.right.key) {
					riPrev.right = null;
				} else {
					riPrev.left = null;
				}
				
				lp.left = tem.left;
				lp.right = tem.right;
				lp.count = tem.count;
				if (key > prev.key) {
					prev.right = lp;
				} else {
					prev.left = lp;
				}
				root = root.right;
				return root;
			}
			//keep finding the key
			if (key > tem.key) {
				prev = tem;
				tem = tem.right;
			} else {
				prev = tem;
				tem = tem.left;
			}
		}
		
		//the delete node doesn't exist
		for (Node n : arr) {
			n.count++;
		}
		
		root = root.right;
		return root;
	}
	
	public void preOrder() {
		//preOrder(root);
		preOrderTraversal(root);
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	//use queue remove first elements and push the elements children into the queue
	public void levelOrder() {
		if (root == null) return;
		Deque<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node curr = queue.removeFirst();
			System.out.println("key: " + curr.key + " " + "count: " + curr.count);
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
		}
		
	}
	
	//return minimum key
	//if root is empty, return -1
	public int minimum() {
		if (root == null) return -1;
		if (root.left == null) return root.key;
		Node tem = root;
		while (tem.left != null) {
			tem = tem.left;
		}
		return tem.key;
	}
	
	//return maximum key
	//if root is empty, return -1
	public int maximum() {
		if (root == null) return -1;
		if (root.right == null) return root.key;
		Node tem = root;
		while (tem.right != null) {
			tem = tem.right;
		}
		return tem.key;
	}
	
	//delete the min node in node and return the node
	public Node deleteMin(Node node) {
		if (node == null) return node;
		//delete the root node
		if (node.left == null) {
			node = node.right;
			return node;
		}
		Node tem = node, prev = node;
		while (tem.left != null) {
			prev = tem;
			tem = tem.left;
		}
		prev.left = tem.right;
		return node;
	}
	
	//return the rank of the key
	public int rank(int key) {
		if (root == null) return 0;
		if (key == root.key) {
			int res = root.count;
			if (root.right != null) {
				res -= root.right.count;
			}
			return res;
		}
		//tem: key node
		Node tem = root;
		int leftCount = 0;
		while (tem != null) {
			if (key == tem.key) {
				int res = 0;
				if (tem.left != null) {
					res += tem.left.count;
				}
				res = res + leftCount + 1;
				return res;
			}
			//if tem in the right node get the left childs count plus 1
			if (key > tem.key) {
				if (tem.left != null) {
					leftCount = leftCount + tem.left.count + 1;
				} else {
					leftCount++;
				}
				tem = tem.right;
			} else {
				tem = tem.left;
			}
		}
		//key is not exist in node
		return 0;
	}
	
	//return kth key in root(kth has (k - 1)'s child
	//if kth is greater then the node size, return the maximal key
	//if kth is less then 1, return the minimal key
	//k start from 1
	public int select(int k) {
		if (k <= 1) {
			//return min
		}
		if (k >= size) {
			//return max
		}
		Node tem = root;
		int leftCount = 0;
		while (tem != null) {
			//calculate tem's count
			int rank = 1;
			if (tem.left != null) {
				rank += tem.left.count;
			}
			rank += leftCount;
			if (rank == k) {
				return tem.key;
			}
			if (k < rank) {
				tem = tem.left;
			} else {
				if (tem.left != null) {
					leftCount += tem.left.count;
				}
				leftCount++;
				tem = tem.right;
			}
		}
		return 0;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(8, 12);
		bst.insert(5, 13);
		bst.insert(12, 13);
		bst.insert(10, 16);
		bst.insert(14, 16);
		bst.insert(13, 14);
		bst.insert(16, 11);
		bst.insert(4, 11);
		bst.insert(6, 11);
		System.out.println(bst.contains(7));
		System.out.println("pre order");
		bst.preOrder();
		System.out.println("in order");
		bst.inOrder();
		System.out.println("post order");
		bst.postOrder();
		System.out.println("level order");
		bst.levelOrder();
		System.out.println("find the minimum and maximum");
		System.out.println("minimum: " + bst.minimum());
		System.out.println("maximum: " + bst.maximum());
		
		int del = 17;
		bst.deleteNode(del);
		System.out.println("after delete " + del + " level order");
		bst.levelOrder();
		
		int rank = 12;
		System.out.println("Rank: " + rank);
		System.out.println(bst.rank(rank));
		
		int select = 6;
		System.out.println("select: " + select);
		System.out.println(bst.select(select));
	}

}
