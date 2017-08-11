package LeetCode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * 
    Input: 
	root = [1, 2, 3], k = 5
	Output: [[1],[2],[3],[],[]]

	Input: 
	root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
	Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 */
public class J725_Split_Linked_List_In_Parts {
	public ListNode[] splitListToParts(ListNode root, int k) {
		if (root == null)
			return null;
		ListNode tem = root;
		int len = 0;
		while (tem != null) {
			len++;
			tem = tem.next;
		}
		
		ListNode[] res = new ListNode[k];
		
		
		if (k >= len) {
			int i = 0;
			tem = root;
			while (tem != null) {
				ListNode next = tem.next;
				tem.next = null;
				res[i] = tem;
				tem = next;
				i++;
			}
			return res;
		}
		
		int nodeNum = len / k;
		//they are addNodeNum value of node need plus one
		int addNodeNum = len - nodeNum * k;
		tem = root;
		for (int i = 0; i < addNodeNum; i++) {
			for (int j = 0; j < nodeNum + 1; j++) {
				//split nodeNum's plus one's list
				tem = tem.next;
			}
		}
		
		
		
		
		
		
		return null;
    }
	
	public static void main(String[] args) {
		
	}
}
