package LeetCode;

public class Algo_LinkedList {
	
	class Node {
		public int data;
		public Node next;
		
		public void displayNodeData() {
			System.out.println("data: " + data);
		}
	}

	public class SinglyLinkedList {
		private Node head;
		
		public boolean isEmpty() {
			return (head == null);
		}
		
		public void insertFirst(int data) {
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = head;
			head = newNode;
		}
		
		public Node deleteFirst() {
			Node temp = head;
			head = head.next;
			return temp;
		}
		
		public void insertLast(int data) {
			Node currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			Node newNode = new Node();
			newNode.data = data;
			currentNode.next = newNode;
		}
		
		public Node deleteLast() {
			Node currentNode = head;
			while (currentNode.next.next != null) {
				currentNode = currentNode.next;
			}
			Node temp = currentNode.next;
			currentNode.next = null;
			return temp;
		}
		
		public Node returnHead() {
			return head;
		}
		
		public Node returnLast() {
			Node currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			return currentNode;
		}
		
		public void deleteNode(int data) {
			Node temp = head;
			Node pre = temp;
			while ((temp.next != null) && (temp.data != data)) {
				pre = temp;
				temp = temp.next;
			}
			pre.next = pre.next.next;
		}
		
		public void printLinkedList() {
			Node currentNode = head;
			System.out.println("displays");
			while (currentNode != null) {
				currentNode.displayNodeData();
				currentNode = currentNode.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Algo_LinkedList al = new Algo_LinkedList();
		SinglyLinkedList list = al.new SinglyLinkedList();
		list.insertFirst(5);
		list.insertFirst(6);
		list.insertFirst(4);
		list.insertLast(10);
		list.printLinkedList();
		list.deleteNode(6);
		list.deleteNode(10);
		list.printLinkedList();
	}
}
