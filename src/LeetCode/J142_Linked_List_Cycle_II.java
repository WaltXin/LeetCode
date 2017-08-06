package LeetCode;

/*
 * Distance from the first node to the start cycle node is A
 * Distance from the start cycle node to the meet node is B
 * Them the slow node travels: A + B
 * The fast node travels: 2A + 2B
 * Let's assume the cycle size: N
 * Then A + B + N = 2A + 2B --> A + B = N
 * The slow node traveled the cycle size.
 * Because B = N - A, the slow node already in B and the slow node already in cycle, 
 * so the slow node just need travel A distance to back to the start point, and in the mean time
 * We can generate a slow2 node from start and travels A distance, slow2 meets slow node that node is the start node
 *         Start: 3  B: meet point  Cycle size N
 * |----A----|----B|
 * 1 -> 2 -> 3 -> 4 -> 5
 *           |         | 
 *           |_________|  
 * 
 * **/

public class J142_Linked_List_Cycle_II {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				ListNode slow2 = head;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow2;
			}
		}
		return null;
	}
	
	//Because the cycle size is N = A + B, so let the fast node travels A we can also calculate the cycle size.
	
	public void cycleSize(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				int length = 1;
				fast = fast.next;
				while (fast != slow) {
					fast = fast.next;
					length++;
				}
				System.out.println(length);
				return;
			}
		}
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
		n5.next = n2;
		ListNode res = new J142_Linked_List_Cycle_II().detectCycle(head);
		System.out.println(res.val);
		//Extra knowledge
		new J142_Linked_List_Cycle_II().cycleSize(head);
	}

}
