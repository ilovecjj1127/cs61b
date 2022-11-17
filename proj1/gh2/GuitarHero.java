package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    static final int KEYS = keyboard.length();

    public static void main(String[] args) {
        GuitarString[] stringArr = new GuitarString[KEYS];
        for (int i = 0; i < keyboard.length(); i++) {
            stringArr[i] = new GuitarString(keyboard.charAt(i));
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i = keyboard.indexOf(key);
                if (i != -1) {
                    stringArr[i].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (int i = 0; i < KEYS; i++) {
                sample += stringArr[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < KEYS; i++) {
                stringArr[i].tic();
            }

        }
    }
}
