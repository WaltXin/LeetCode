package LeetCode;

public class J19_Remove_Nth_Node_From_End_of_List {
	public ListNode solution(ListNode head, int k) {
		//return kth
		if (head == null || (head.next == null && k == 1)) {
			return null;
		}
		
		ListNode fast = head, slow = head, prev = null;
		//because delete kth from end, let fast travel kth first, 
		//if fast reach the null it means slow is point to the delete node
		//  1 =< k <= length
		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}
		
		if (fast == null) {
			return head.next;
		} else {
			while (fast != null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next;
			}
			prev.next = slow.next;
			return head;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode res = new J19_Remove_Nth_Node_From_End_of_List().solution(head, 1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
