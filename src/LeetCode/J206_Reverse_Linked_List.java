package LeetCode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class J206_Reverse_Linked_List {
	
	public ListNode reverseList(ListNode head) {
		ListNode before = null;
		ListNode temp = head;
		while (temp != null) {
			ListNode next = temp.next;
			temp.next = before;
			before = temp;
			temp = next;
		}
		//while loop stops when temp is null, so the last loop before temp = next, before is the last node, which is the head
		return before;
	}
}
