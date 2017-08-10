package LeetCode;

public class J2_Add_Two_Numbers {
public ListNode solution(ListNode l1, ListNode l2) {
		
		if (l1 == null && l2 == null) {
			return null;
		} else if (l2 == null) {
			return l1;
		} else if (l1 == null) {
			return l2;
		}
		ListNode res = new ListNode(0);
		ListNode tem = res;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int val;
			if (l1 == null) {
				val = l2.val + carry;
				carry = 0;
			} else if (l2 == null) {
				val = l1.val + carry;
				carry = 0;
			} else {
				val = l1.val + l2.val + carry;
				carry = 0;
			}
			if (val >= 10) {
				val = val - 10;
				carry++;
			}
			tem.next = new ListNode(val);
			tem = tem.next;
			//need check if l1 or l2 is null
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry == 1) {
			tem.next = new ListNode(1);
		}
		return res.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(4);
		ListNode l2 = new ListNode(1);
		ListNode t2 = new ListNode(0);
		ListNode t3 = new ListNode(7);
		l1.next = n1;
		n1.next = n2;
		l2.next = t2;
		t2.next = t3;
		
		ListNode res = new J2_Add_Two_Numbers().solution(l1, l2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
		
	}
}
