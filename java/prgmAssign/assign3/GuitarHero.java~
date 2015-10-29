/*
 * GuitarHero.java
 * 
 * "I pledge my honor that I have abided by the Stevens Honor System"
 *
 */

package assign3;

import cos126.StdDraw;
import cos126.StdAudio;

/**
 */
public class GuitarHero {
    public static void main(String[] args) {
	final double CONCERT_A = 440.0,
	    CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
	GuitarString stringA = new GuitarString(CONCERT_A);
	GuitarString stringC = new GuitarString(CONCERT_C);

	while(true) {
	    if (StdDraw.hasNextKeyTyped()) {
		char key = StdDraw.nextKeyTyped();
		if      (key == 'A') { stringA.pluck(); }
		else if (key == 'C') { stringC.pluck(); }
	    }

	    double sample = stringA.sample() + stringC.sample();

	    StdAudio.play(sample);

	    stringA.tic();
	    //stringC.tic();
	}
    }
}
