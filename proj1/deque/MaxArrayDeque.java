package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparison;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparison = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }
        T maxElement = get(0);
        for (int i = 0; i < size(); i++) {
            if (comparison.compare(get(i), maxElement) > 0) {
                maxElement = get(i);
            }
        }
        return maxElement;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxElement = get(0);
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(i), maxElement) > 0) {
                maxElement = get(i);
            }
        }
        return maxElement;
    }
}
