package LeetCode;
import java.util.Map;
import java.util.HashMap;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
	};

public class J138_Copy_List_With_Random_Point {

	public RandomListNode copyRandomList(RandomListNode head) {
        //use HashMap
		if (head == null)
			return null;
		
		RandomListNode tem = head;
		
		Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		//first loop: store the origin node as key and generate new node as value
		while (tem != null) {
			map.put(tem, new RandomListNode(tem.label));
			tem = tem.next;
		}
		
		//second loop: assign next and random point to new node(value)
		tem = head;
		while (tem != null) {
			//assign the new node(value) the tem's next value
			map.get(tem).next = map.get(tem.next);
			map.get(tem).random = map.get(tem.random);
			tem = tem.next;
		}
		
		//return the new node head
		return map.get(head);
    }
}
