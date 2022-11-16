package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {
    private class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(IntNode p, T i, IntNode n) {
            item = i;
            next = n;
            prev = p;
        }

//        public IntNode(IntNode p, T i) {
//            item = i;
//            prev = p;
//        }
    }

    private IntNode sentinel;
    private IntNode last;

    private int size;

    @Override
    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;

        size += 1;
    }

    @Override
    public void addLast(T item) {
        last.prev = new IntNode(last.prev, item, last);
        last.prev.prev.next = last.prev;

        size += 1;
    }

    @Override
    public T removeFirst() {
        if (sentinel.next.item == null) {
            return null;
        }
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return temp;
    }

    @Override
    public T removeLast() {
        if (last.prev.item == null) {
            return null;
        }
        T temp = last.prev.item;
        last.prev = last.prev.prev;
        last.prev.next = last;
        size -= 1;
        return temp;
    }

    @Override
    public T get(int index) {
        IntNode temp = sentinel.next;
        if (index > size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public LinkedListDeque() {
        sentinel = new IntNode(null, (T) null, null);
        last = new IntNode(sentinel, (T) null, null);
        sentinel.next = last;
        size = 0;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int n, IntNode head) {
        if (n == 0) {
            return head.item;
        }
        n -= 1;
        return getRecursiveHelper(n, head.next);
    }

    public Iterator<T> iterator() {

        return null;
    }

//    public boolean equals(Object o) {
//        return true;
//    }
}
