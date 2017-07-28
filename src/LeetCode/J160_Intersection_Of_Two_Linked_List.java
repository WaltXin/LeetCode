package LeetCode;

public class J160_Intersection_Of_Two_Linked_List {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//get the length for headA and headB
		int lenA = len(headA);
		int lenB = len(headB);
		//let headA and headB start in same position
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenA < lenB) {
			headB = headB.next;
			lenB--;
		}
		//now headA and headB has the same length
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
        return headA;
    }
	
	public int len(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}
}
