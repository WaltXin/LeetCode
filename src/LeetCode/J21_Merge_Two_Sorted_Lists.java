package LeetCode;

public class J21_Merge_Two_Sorted_Lists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		while (l1 != null || l2 != null) {
			
			if (l1 == null) {
				temp.next = l2;
				temp = temp.next;
				l2 = l2.next;
				continue;
			}
			if (l2 == null) {
				temp.next = l1;
				temp = temp.next;
				l1 = l1.next;
				continue;
			}
			if (l1.val >= l2.val) {
				temp.next = l2;
				temp = temp.next;
				l2 = l2.next;
			} else {
				temp.next = l1;
				temp = temp.next;
				l1 = l1.next;
			}
		}
		
		head = head.next;
        return head;
    }
	
	public static void test(ListNode head) {
		ListNode l = new ListNode(1);
		ListNode temp = l;
		while (head != null) {
			temp.next = head;
			temp = temp.next;
			head = head.next;
		}
		
		System.out.println("d");
		System.out.println("d");
		
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n3;
		n3.next = n5;
		n2.next = n4;
		n4.next = n6;
		
		ListNode head = new J21_Merge_Two_Sorted_Lists().mergeTwoLists(n1,n2);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}

}
