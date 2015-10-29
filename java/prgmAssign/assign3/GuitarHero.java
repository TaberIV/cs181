/*
 * GuitarHero.java
 * 
 * "I pledge my honor that I have abided by the Stevens Honor System"
 *
 */

package assign3;

import cos126.*;
import java.util.Scanner;
import java.io.File;

/**
 */
public class GuitarHero {
    public static void main(String[] args) {
	final String keyboard = "1234567890qwertyuiopasdfghjklzxcvbnm,";
	char key;
	int keyIndex;
	double sample;
	GuitarString[] strings = new GuitarString[37];

	for(int i=0; i<37; i++){
	    strings[i] = new GuitarString(440.0 * Math.pow(2, (i - 24)/12.0));
	}

	if (args.length == 0) {
	    while(true) {
		if (StdDraw.hasNextKeyTyped()) {
		    key = StdDraw.nextKeyTyped();
		    keyIndex = keyboard.indexOf(key);

		    if(keyIndex != -1)
			strings[keyIndex].pluck();
		}

		sample = 0;
		for(GuitarString string : strings)
		    sample += 10*string.sample();

		StdAudio.play(sample);

		for(GuitarString string : strings)
		    string.tic();
	    }
	}
	else if (args.length == 2 && args[0].equals("-play_from_file")) {
	    //File song = new File(args[1]);
	    Scanner song = new Scanner(args[1]);
	    song.next();
	    System.out.println(song.next());
	    
	}
	else { 
	    System.out.println("GuitarHero.java has two optional arguments,"
			       + " -play_from_file and then a mutually neccesary file");
	}
    }
}