package LeetCode;

public class J143_Reorder_List {

	public ListNode reorderList(ListNode head) {
		
		if (head == null || head.next == null)
			return head;
		
		ListNode fast = head, slow = head, prev = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = null;
		
		ListNode revPrev = null;
		while (slow != null) {
			ListNode next = slow.next;
			slow.next = revPrev;
			revPrev = slow;
			slow = next;
		}
		slow = revPrev;
		
		ListNode res = new ListNode(0);
		ListNode resTem = res;
		int i = 1;
		while (head != null || slow != null) {
			if (i % 2 != 0 && head != null) {
				resTem.next = head;
				head = head.next;
				resTem = resTem.next;
				i++;
			} else {
				resTem.next = slow;
				slow = slow.next;
				resTem = resTem.next;
				i++;
			}
		}
		
		return res.next;
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
		//n4.next = n5;
		ListNode res = new J143_Reorder_List().reorderList(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
