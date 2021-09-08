package Trie_DS;

import java.util.Arrays;

public class NewArrayList<E>{
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    Object[] elements;

    public NewArrayList() {
          elements = new Object[DEFAULT_CAPACITY];
    }

    public NewArrayList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("invalid argument");
        elements = new Object[capacity];
    }

    public void add(E e) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = e;
    }

    public E get(int i) {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("index out of bound");

        return (E) elements[i];
    }

    private void increaseCapacity() {
        int newSize = size * 2;
        elements = Arrays.copyOf(elements, newSize);
    }


    public static void main(String[] args) {
        NewArrayList list = new NewArrayList();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }

        System.out.println(list.get(14));
    }
}