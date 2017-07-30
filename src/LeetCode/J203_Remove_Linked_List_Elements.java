package LeetCode;

public class J203_Remove_Linked_List_Elements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode node = new ListNode(1);
		node.next = head;
        ListNode temp = node;
        while (temp != null && temp.next != null) {
            if (temp.next.val != val) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        node = node.next;
        return node;
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode res = new J203_Remove_Linked_List_Elements().removeElements(n1, 1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
