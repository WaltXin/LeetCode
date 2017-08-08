package LeetCode;

public class J147_Insertion_Sort_List {

	public ListNode insertionSortList(ListNode head) {
		
		if (head == null || head.next == null)
			return head;
		
		ListNode tem = head;
		int val = head.val;
		ListNode prev = null;
		while (tem != null) {
			if (val <= tem.val) {
				val = tem.val;
				prev = tem;
				tem = tem.next;
			} else {
				//insert tem node in list
				prev.next = tem.next;
				ListNode insertList = head;
				int insertVal = head.val;
				
				if (tem.val < insertVal) {
					tem.next = head;
					head = tem;
					tem = prev.next;
				} else {
					ListNode insertPrev = null;
					while (tem.val > insertVal) {
						insertPrev = insertList;
						insertList = insertList.next;
						insertVal = insertList.val;
					}
					tem.next = insertPrev.next;
					insertPrev.next = tem;
					//tem has changed, use prev.next get the origin tem
					tem = prev.next;
				}
			}
		}
		return head; 
    }
	
	public ListNode insertionSortListSolution2(ListNode head) {
		ListNode curr = head, next = null;
		ListNode dummy = new ListNode(0);
		
		while (curr != null) {
			next = curr.next;
			
			ListNode p = dummy;
			while (p.next != null && p.next.val < curr.val)
				p = p.next;
			
			//insert curr between p and p.next
			curr.next = p.next;
			p.next = curr;
			curr = next;
		}
		
		return dummy.next;
	}
	
	
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(0);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode res = new J147_Insertion_Sort_List().insertionSortListSolution2(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
