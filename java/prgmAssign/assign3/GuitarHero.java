/*
 * GuitarHero.java
 * 
 * "I pledge my honor that I have abided by the Stevens Honor System"
 *
 */

package assign3;

import cos126.*;
import java.io.*;

/**
 */
public class GuitarHero {
    public static void main(String[] args) {
	final String keyboard = "1234567890qwertyuiopasdfghjklzxcvbnm,";
	char key;
	int keyIndex;
	double sample = 0;
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
		    sample += string.sample();

		StdAudio.play(sample);

		for(GuitarString string : strings)
		    string.tic();
	    }
	}
	else if (args.length == 2 && args[0].equals("-play_from_file")) {
	    try {
		String file = "assign3/" + args[1], line;
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		long time;

		line = buffer.readLine();
		time = Long.parseLong(line.substring(0, line.indexOf(" ")));
		do {
		    if(strings[0].time() == time) {
			for(int i=(line.indexOf(" ")+1); i<line.length(); i++){
			    strings[keyboard.indexOf(line.charAt(i))].pluck();
			}
			line = buffer.readLine();
			time = (long) (10000.0 * Double.parseDouble(line.substring(0, line.indexOf(" "))));
		    }
		    
		    while(strings[0].time < time) {
			sample = 0;
			for(GuitarString string : strings)
			    sample += string.sample();

			StdAudio.play(sample);
		    
			for(GuitarString string : strings)
			    string.tic();
		    }
		    
		} while(line.substring(line.indexOf(" ")).length() > 1);
		
		buffer.close();
	    }
	    
	    catch(FileNotFoundException ex) {
		System.out.println("Unable to open file '" + args[1] +  "'");
	    }
	    catch(IOException ex) {
		System.out.println("Error reading file '" + args[1] + "'");
	    }
	}
	else { 
	    System.out.println("GuitarHero.java has two optional arguments,"
			       + " -play_from_file and then a mutually neccesary file");
	}
    }
}
