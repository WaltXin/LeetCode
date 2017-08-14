package LeetCode;

/**
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL
 * 1 ≤ m ≤ n ≤ length
 * */

public class J92_Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
        	return head;
        
        //split to 3 parts start - reverse list - end
        ListNode prev = null, tem = head;
        for (int i = 1; i < m; i++) {
        	prev = tem;
        	tem = tem.next;
        }
        if (prev != null)
        	prev.next = null;
        //prev store the last node of first part
        
        ListNode last = tem;
        for (int i = m; i <= n; i++) {
        	last = last.next;
        }
        //the prev1 for reverse point to the after reverse node 
        ListNode prev1 = last;
        for (int i = m; i <= n; i++) {
        	ListNode next = tem.next;
        	tem.next = prev1;
        	prev1 = tem;
        	tem = next;
        }
        
        //connect first part and second part
        if (prev != null)
        	prev.next = prev1;
        else
        	head = prev1;
        return head;        
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
		ListNode res = new J92_Reverse_Linked_List_II().reverseBetween(head, 1, 5);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
