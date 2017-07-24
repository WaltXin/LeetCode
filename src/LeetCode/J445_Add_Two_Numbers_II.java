package LeetCode;

/**
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	}
 * */

public class J445_Add_Two_Numbers_II {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverseNode(l1);
		l2 = reverseNode(l2);
		int offset = 0;
		ListNode result = new ListNode(0);
		ListNode d = result;
		
		while (l1 != null || l2 != null) {
			int res = 0;
			int v1 = 0;
			int v2 = 0;
			if (l1 != null) {
				v1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				v2 = l2.val;
				l2 = l2.next;
			}
			res = v1 + v2 + offset;
			if (res >= 10) {
				res = res - 10;
				offset = 1;
			} else {
				offset = 0;
			}
			ListNode newNode = new ListNode(res);
			d.next = newNode;
			d = d.next;
		}
		if (offset == 1) {
			d.next = new ListNode(1);
		}
		result = result.next;
		result = reverseNode(result);
		//Enable for testing
		/**
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		**/
		return result;
    }
	
	public ListNode reverseNode(ListNode listNode) {
		ListNode temp = listNode;
		ListNode before = null;
		while (temp != null) {
			ListNode next = temp.next;
			temp.next = before;
			before = temp;
			temp = next;
		}
		listNode = before;
		return listNode;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(7);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode t1 = new ListNode(5);
		ListNode t2 = new ListNode(6);
		ListNode t3 = new ListNode(4);
		t1.next = t2;
		t2.next = t3;
		new J445_Add_Two_Numbers_II().addTwoNumbers(n1, t1);
	}
	
	
}
