package LeetCode;

public class J86_Partition_List {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null || x == Integer.MIN_VALUE)
        	return head;
       
        ListNode dummy = new ListNode(x - 1);
        dummy.next = head;
        
        //index is the node index, i is the insert point
        int index = 0,i = 0;
        ListNode prev = null;
        
        ListNode tem = dummy;
        tem = tem.next;
        while (tem != null) {
        	if (tem.val < x && index != i) {
        		//insert tem node after i node
        		ListNode insertTem = dummy;
        		for (int j = 0; j < i; j++) {
        			insertTem = insertTem.next;
        		}
        		
        		prev.next = tem.next;
        		ListNode next = insertTem.next;
        		insertTem.next = tem;
        		tem.next = next;
        		tem = prev.next;
        		i++;
        		index++;
        	} else {
        		index++;
        		if (tem.val < x) {
        			i++;
        		}
        		prev = tem;
        		tem = tem.next;
        	}
        }
        
        return dummy.next;
    }
    //The second solution is create two list, one store the node list less then target
    //And one store the list >= target. them merge these two list
    public ListNode solution(ListNode head, int n) {
		//values less then n will be put in front of n eg 14322 n = 3 -> 12243
		//similar with insertion sort
		if (head == null || head.next == null)
			return head;
		ListNode less = new ListNode(0), great = new ListNode(0);
		ListNode lTem = less, gTem = great, tem = head;
		while (tem != null) {
			if (tem.val < n) {
				lTem.next = tem;
				lTem = lTem.next;
			} else {
				gTem.next = tem;
				gTem = gTem.next;
			}
			tem = tem.next;
		}
		lTem.next = great.next;
		return less.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode res = new J86_Partition_List().solution(head, 3);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
