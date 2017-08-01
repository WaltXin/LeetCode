package LeetCode;

public class J24_Swap_Nodes_In_Pairs {

	public ListNode swapPairs(ListNode head) {
		//the idea is revert linked list then treated two nodes as single node, then reverse again
		if (head == null || head.next == null) {
			return head;
		}
		
		//reverse list
		int len = 0;
		ListNode prev = null;
		while (head != null) {
			len++;
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		head = prev;
		
		//reverse two nodes together
		ListNode temp = null;
		if (len % 2 != 0) {
			temp = head;
			head = head.next;
			temp.next = null;
		}
		
		ListNode secPrev = null;
		while (head != null && head.next != null) {
			ListNode next = head.next.next;
			head.next.next = secPrev;
			secPrev = head;
			head = next;
		}
		head = secPrev;
		
		if (temp != null) {
			ListNode temps = head;
			while (temps.next != null) {
				temps = temps.next;
			}
			temps.next = temp;
		}
		
		return head;
    }
	
	//Not constant space
	public ListNode swapPairsWithRecursion(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairsWithRecursion(head.next.next);
		next.next = head;
		return next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		//n5.next = n6;
		
		ListNode res = new J24_Swap_Nodes_In_Pairs().swapPairsWithRecursion(n1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
