package deque;


public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = moveForward(nextFirst);
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = moveBackward(nextLast);
    }

    @Override
    public T removeFirst() {
        if (items[getFirstIndex()] == null) {
            return null;
        }
        if (size < items.length / 4 && (size > 4)) {
            resize(items.length / 4);
        }
        T out = items[getFirstIndex()];
        items[getFirstIndex()] = null;
        nextFirst = moveBackward(nextFirst);
        size -= 1;
        return out;
    }

    @Override
    public T removeLast() {
        if (items[getLastIndex()] == null) {
            return null;
        }
        if (size < items.length / 4 && (size > 4)) {
            resize(items.length / 4);
        }
        T out = items[getLastIndex()];
        items[getLastIndex()] = null;
        nextLast = moveForward(nextLast);
        size -= 1;
        return out;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void printDeque() {
        int first = getFirstIndex();
        for (int i = 0; i < size; i++) {
            if (first + i > items.length - 1) {
                System.out.print(items[first + i - items.length] + " ");
            } else {
                System.out.print(items[first + i] + " ");
            }
        }
        System.out.println();
    }

    public void resize(int capacity) {
        int first = getFirstIndex();
        int last = getLastIndex();
        T[] tmp = (T[]) new Object[capacity];

        if (first < last) {
            int j = 0; // set from the first index of the new array
            for (int i = first; i < last + 1; i++) {
                tmp[j] = items[i];
                j += 1;
            }
            nextFirst = capacity - 1;
            nextLast = size;
        } else if (first > last) {
            int j = capacity - 1;
            for (int i = items.length - 1; i >= first; i--) {
                tmp[j] = items[i];
                j -= 1;
            }
            nextFirst = j;
            for (int i = 0; i <= last; i++) {
                tmp[i] = items[i];
            }
            // nextLast does not change
        }
        items = tmp;


    }

    private class ArrayIterator implements Iterator<T> {
        private int wizPos;

        public ArrayIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque) || size != ((Deque<?>) o).size()) {
            return false;
        }
        Iterator<T> iter = this.iterator();
        Iterator<T> itero = ((Deque<?>) o).iterator();
        while (iter.hasNext()) {
            if (!iter.next().equals(itero.next())) {
                return false;
            }
        }

        return true;
    }

    private int getLastIndex() {
        if (nextLast == 0) {
            return items.length - 1;
        }
        return nextLast - 1;
    }

    private int getFirstIndex() {
        if (nextFirst + 1 == items.length) {
            return 0;
        }
        return nextFirst + 1;
    }

    private int moveForward(int next) {
        if (next == 0) {
            next = items.length - 1;
        } else {
            next -= 1;
        }
        return next;
    }

    private int moveBackward(int next) {
        if (next == items.length - 1) {
            next = 0;
        } else {
            next += 1;
        }
        return next;
    }

    private T getFirst() {
        if (nextFirst + 1 == items.length) {
            return items[0];
        }
        return items[nextFirst + 1];
    }

    private T getLast() {
        if (nextLast == 0) {
            return items[items.length - 1];
        }
        return items[nextLast - 1];
    }

}
