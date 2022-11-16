package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {

    @Test
    public void findMaxTest() {
        Comparator<Integer> c = compare();
        MaxArrayDeque<Integer> mad = new MaxArrayDeque<Integer>(c);
        mad.addFirst(2);
        mad.addFirst(9);
        mad.addFirst(0);
        mad.addFirst(10);
        mad.addFirst(-5);
        int result = mad.max();
        assertEquals(result, 10);
    }

    private Comparator<Integer> compare() {
    }

}
