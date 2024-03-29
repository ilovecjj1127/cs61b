package tester;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeEC {
    @Test
    public void testArratDeque() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        // addLast
        for (int i=0; i<10; i++) {
            int random = StdRandom.uniform(100);
            ads.addLast(random);
            sad.addLast(random);
        }
        for (int i=0; i<10; i++) {
            int actual = ads.get(i);
            int expected = sad.get(i);
            assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        // addFirst
        for (int i=0; i<10; i++) {
            int random = StdRandom.uniform(100);
            ads.addFirst(random);
            sad.addFirst(random);
        }
        for (int i=0; i<10; i++) {
            int actual = ads.get(i);
            int expected = sad.get(i);
            assertEquals("Oh noooo!\nThis is bad in addFirst():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

    }


    @Test
    public void testArratDeque2() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        int random = StdRandom.uniform(100);
        ads.addFirst(random);
        sad.addFirst(random);
        assertEquals("addFirst("+random+")", ads.get(0), sad.get(0));
        System.out.println("addFirst("+random+")");

        random = StdRandom.uniform(100);
        ads.addLast(random);
        sad.addLast(random);
        assertEquals("addLast("+random+")", ads.get(1), sad.get(1));
        System.out.println("addLast("+random+")");

        int actual = ads.removeFirst();
        int expected = ads.removeFirst();
        assertEquals("removeFirst()", actual, expected);
        System.out.println("removeFirst()");

        actual = ads.removeLast();
        expected = sad.removeLast();
        assertEquals("removeLast()", actual, expected);
        System.out.println("removeLast()");
    }

//    @Test
//    public void randomTest() {
//        StudentArrayDeque<Integer> stuad = new StudentArrayDeque<>();
//        ArrayDequeSolution<Integer> crtad = new ArrayDequeSolution<>();
//
//        int N = 10000;
//        for (int i = 0; i < N; i++) {
//            int operationNumber = StdRandom.uniform(0, 7);
//            if (operationNumber == 0) {
//                // addLast
//                int randVal = StdRandom.uniform(0, 100);
//                stuad.addLast(randVal);
//                crtad.addLast(randVal);
//            } else if (operationNumber == 1 && !crtad.isEmpty() && !stuad.isEmpty()) {
//                // removeFirst
//                Integer student = stuad.removeFirst();
//                Integer solution = crtad.removeFirst();
//                assertEquals("Test failed!\n Correct removed first: " + solution + "\n You removed first: " + student,
//                        solution, student);
//            } else if (operationNumber == 2) {
//                // size
//                assertEquals("size failed", crtad.size(), stuad.size());
//            } else if (operationNumber == 3 && !crtad.isEmpty() && !stuad.isEmpty()) {
//                // removeLast
//                Integer student = stuad.removeLast();
//                Integer solution = crtad.removeLast();
//                assertEquals("Test failed!\n Correct removed last: " + solution + "\n You removed last: " + student,
//                        solution, student);
//            } else {
//                // addFirst
//                int randVal = StdRandom.uniform(0, 100);
//                stuad.addFirst(randVal);
//                crtad.addFirst(randVal);
//            }
//        }
//    }
}
