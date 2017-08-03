package LeetCode;

public class J148_Sort_List {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode fast = head, slow = head, prev = null;
		
		//prev is the previous slow node
		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		//Separate two list head and slow
		prev.next = null;
		
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		
		return merge(l1, l2);
	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				temp.next = l2;
				l2 = l2.next;
			} else if (l2 == null) {
				temp.next = l1;
				l1 = l1.next;
			} else if (l2.val < l1.val) {
				temp.next = l2;
				l2 = l2.next;
			} else {
				temp.next = l1;
				l1 = l1.next;
			}
			temp = temp.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode res = new J148_Sort_List().sortList(n1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
