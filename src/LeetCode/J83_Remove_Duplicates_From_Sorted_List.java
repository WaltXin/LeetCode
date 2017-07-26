package LeetCode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class J83_Remove_Duplicates_From_Sorted_List {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        
        while (temp != null) {
        	if (temp.next == null) {
        		break;
        	}
        	if (temp.val == temp.next.val) {
        		temp.next = temp.next.next;
        	} else {
        		temp = temp.next;
        	}
        }
        return head;
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode result = new J83_Remove_Duplicates_From_Sorted_List().deleteDuplicates(n1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
