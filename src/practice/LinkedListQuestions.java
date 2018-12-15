package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    ListNode next;
    int val;
    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * reverse, insert, delete, two pointer(fast, slow)
 * cycle detection(find the cycle start, by put fast in head and slow and fast both speed = 1)
 *
 * Consider: head, tail
 * skill: two pointer, dummy node
 * */

public class LinkedListQuestions {

    //insert insertVal before the first target we find
    public ListNode insert(ListNode node, int insertVal, int target) {
        //find the target and store previous node
        //create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode prev = dummy;
        ListNode curr = node;

        while (curr != null && curr.val != target) {
            prev = curr;
            curr = curr.next;
        }

        //if target not found, add insertVal in the end
        if (curr == null) {
            ListNode insertNode = new ListNode(insertVal);
            prev.next = insertNode;
        } else {
            ListNode insertNode = new ListNode(insertVal);
            insertNode.next = curr;
            prev.next = insertNode;
        }

        return dummy.next;
    }

    //delete target value
    public ListNode delete(ListNode node, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode prev = dummy;
        ListNode curr = node;

        while (curr != null && curr.val != target) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        }

        return dummy.next;
    }

    public ListNode convertToList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode root = new ListNode(arr[0]);
        ListNode curr = root;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            curr.next = next;
            curr = curr.next;
        }
        return root;
    }

    public static void print(ListNode node) {
        if (node == null) return;
        ListNode curr = node;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparing(k -> k.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            ListNode add = node.next;

            if (add != null) {
                pq.add(add);
            }

            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //has cycle
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    //reverse list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    //remember split odd and even
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);

        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        ListNode curr = head;
        while (curr != null) {
            odd.next = curr;
            odd = curr;
            curr = curr.next;

            if (curr == null) {
                break;
            }
            even.next = curr;
            even = curr;
            curr = curr.next;
        }
        even.next = null;
        odd.next = evenDummy.next;
        return oddDummy.next;
    }


    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6,7};
       ListNode root = new LinkedListQuestions().convertToList(arr);
       //ListNode res = new LinkedListQuestions().insert(root, 4, 5);
       ListNode result = new LinkedListQuestions().oddEvenList(root);
       print(result);

       int t = -121;
       String st = t + "";
       System.out.println(st);
    }
}
