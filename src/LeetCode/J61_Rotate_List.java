package LeetCode;

public class J61_Rotate_List {

	public ListNode rotateRight(ListNode head, int k) {
		//rotate list by k. get k % len steps, then reverse list first and in the k % len nodes, reverse the next list.
		// 5 > 4 > 3 > 2 > 1 k = 2  ->  1 > 2 > 3 > 4 > 5  ->  1 > 2 > 5 > 4 > 3
		if (head == null || head.next == null) {
			return head;
		}
		int len = 0;
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
			len++;
		}
		//prev is the reversed list
		head = prev;
		int loop = k % len;
		
		ListNode secPrev = null;
		ListNode temp = head;
		while (temp != null) {
			if (--loop >= 0) {
				temp = temp.next;
			} else {
				ListNode next = temp.next;
				temp.next = secPrev;
				secPrev = temp;
				temp = next;
			}
		}
		temp = head;
		loop = k % len;
		while ( loop > 0) {
			temp = temp.next;
			loop--;
		}
		temp.next = secPrev;
		return head;
	}
	
	public ListNode rotateRightSolution(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		//get length and get the last node
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		//f is the final value in list, and after the rotate, It will link to the first value
		//s is the last value after the rotate, should point to null in the end.
		ListNode f = dummy, s = dummy;
		int i;
		for (i = 0; f.next != null; i++) {
			f = f.next;
		}
		
		//get i - n % i
		for (int j = i -  (k % i); j > 0; j--) {
			s = s.next;
		}
		
		f.next = dummy.next;
		dummy.next = s.next;
		s.next = null;
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode res = new J61_Rotate_List().rotateRightSolution(n1, 2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
		
	}

}
