package Trie_DS;

import java.util.LinkedList;
import java.util.List;


public class NewLinkedList<E> {

    static class Node<E> {
        public E value;

        public Node (E val) {
            this.value = val;
        }

        Node next;
    }

    Node root;
    Node curr;
    int size;

    public void add(E e) {
        Node newNode = new Node(e);
        if (size == 0) {
            root = newNode;
            curr = root;
        } else {
            curr.next = newNode;
            curr = curr.next;
        }
        size++;
    }

    public E get() {
        return (E) root.value;
    }

    public static void main(String[] args) {
        NewLinkedList list = new NewLinkedList();
        list.add(15);
        System.out.println(list.get());

        List<Integer> list1 = new LinkedList<>();
        list1.add(23);
        list1.add(25);
        System.out.println(list1.get(1));
    }
}
