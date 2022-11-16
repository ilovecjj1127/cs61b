package tester;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeEC {
    @Test
    public void randomTest() {
        StudentArrayDeque<Integer> stuad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> crtad = new ArrayDequeSolution<>();

        int N = 10000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 7);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                stuad.addLast(randVal);
                crtad.addLast(randVal);
            } else if (operationNumber == 1 && !crtad.isEmpty() && !stuad.isEmpty()) {
                // removeFirst
                Integer student = stuad.removeFirst();
                Integer solution = crtad.removeFirst();
                assertEquals("Test failed!\n Correct removed first: " + solution + "\n You removed first: " + student,
                        student, solution);
            } else if (operationNumber == 2) {
                // size
                assertEquals("size failed", crtad.size(), stuad.size());
            } else if (operationNumber == 3 && !crtad.isEmpty() && !stuad.isEmpty()) {
                // removeLast
                Integer student = stuad.removeLast();
                Integer solution = crtad.removeLast();
                assertEquals("Test failed!\n Correct removed last: " + solution + "\n You removed last: " + student,
                        student, solution);
            } else {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                stuad.addFirst(randVal);
                crtad.addFirst(randVal);
            }
        }
    }
}
