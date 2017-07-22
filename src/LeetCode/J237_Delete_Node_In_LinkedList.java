package LeetCode;

/**
 * We can't really delete the node, but we can copy the next node's value and "next" node in to the "delete" node
 * */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	 }

public class J237_Delete_Node_In_LinkedList {
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
