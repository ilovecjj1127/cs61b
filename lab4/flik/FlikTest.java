package flik;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FlikTest {

    @Test
    public void flikTest() {
        int N = 1000;
        int j = 0;
        for (int i = 0; i < N; i++, j++) {
//            int randomNum = StdRandom.uniform(0, 100);
//            int randomNum2 = randomNum;
            System.out.println(i);
            assertTrue(Flik.isSameNumber(i, j));
        }
    }
}
