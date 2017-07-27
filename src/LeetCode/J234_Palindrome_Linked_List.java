package LeetCode;


public class J234_Palindrome_Linked_List {
	public boolean isPalindrome(ListNode head) {
		//Find middle node with fast and slow pointer
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) {
			//Odd number, ignore the middle value
			slow = slow.next;
		}
		slow = reverse(slow);
		
		//reversed slow eg: 134431 becomes head:134431 and slow:134
		while (slow != null) {
			if (slow.val != head.val) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
    }
	
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		boolean res = new J234_Palindrome_Linked_List().isPalindrome(n1);
		System.out.println(res);
	}

}
