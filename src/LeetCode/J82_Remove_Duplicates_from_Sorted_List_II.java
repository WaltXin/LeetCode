package LeetCode;

public class J82_Remove_Duplicates_from_Sorted_List_II {
	
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode tem = dummy;
    	ListNode curr = head;
    	while (curr != null) {
    		while (curr.next != null && curr.next.val == curr.val) {
    			curr = curr.next;
    		}
    		//check if dummy already add the current node, if yes, remove it
    		if (tem.next == curr) {
    			tem = tem.next;
    		} else {
    			tem.next = curr.next;
    		}
    		curr = curr.next;
    	}
    	
        return dummy.next;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(6);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode res = new J82_Remove_Duplicates_from_Sorted_List_II().deleteDuplicates(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
