package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class J328_Odd_Even_Linked_List {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) return null;
		ListNode oddHead = new ListNode(1);
		ListNode evenHead = new ListNode(1);
		ListNode temp = head;
		int i = 1;
		while (temp != null) {
			ListNode next = temp.next;
			if (i % 2 != 0) {
				temp.next = null;
				ListNode tempOdd = oddHead;
				while (tempOdd.next != null) {
					tempOdd = tempOdd.next;
				}
				tempOdd.next = temp;
			} else {
				temp.next = null;
				ListNode tempEven = evenHead;
				while (tempEven.next != null) {
					tempEven = tempEven.next;
				}
				tempEven.next = temp;
			}
			temp = next;
			i++;
		}
		oddHead = oddHead.next;
		evenHead = evenHead.next;
		ListNode tempOdd = oddHead;
		while (tempOdd.next != null) {
			tempOdd = tempOdd.next;
		}
		tempOdd.next = evenHead;
	
		return oddHead;
	}
	
	public ListNode oddEvenListSmartSolution(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
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
		
		ListNode result = new J328_Odd_Even_Linked_List().oddEvenListSmartSolution(n1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
