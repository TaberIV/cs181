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
    /*
     * Plays notes entered by key stroke or file
     *
     * @param play_from_file, if prestent, plays notes from indicated file
     * @param file, simply a String of the name of a file in the package directory
     *        Should be formatted with an integer indicating how long to play the 
     *        following notes, followed by a space, followed by charecters
     *        that can befound in the string keyboard, defined below.
     *        The file should end with a line containing only a '!' 
     */
    public static void main(String[] args) {
	final String keyboard = "1234567890qwertyuiopasdfghjklzxcvbnm,";
	char key; //Stores a keystroke, not musical key
	double sample = 0;
	GuitarString[] strings = new GuitarString[37];

	for(int i=0; i<37; i++){
	    strings[i] = new GuitarString(440.0 * Math.pow(2, (i - 24)/12.0));
	}

	if (args.length == 0) {
	    while(true) {
		if (StdDraw.hasNextKeyTyped()) {
		    key = StdDraw.nextKeyTyped();

		    if(keyboard.indexOf(key) != -1)
			strings[keyboard.indexOf(key)].pluck();
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
		long playTime;
		
		do {
		    do {
			line = buffer.readLine();
		    } while(line.equals(""));

		    if(line.equals("!")){
			break;
		    }
		    
		    playTime = (long) (17000.0 * Double.parseDouble(line.substring(0, line.indexOf(" "))));
		    //17000.0 was considered a decent number to make an entered 1 about 1 beat
		    
		    for(int i=(line.indexOf(" ")+1); i<line.length(); i++){
			strings[keyboard.indexOf(line.charAt(i))].pluck();
		    }
		    
		    while(playTime > 0) {
			sample = 0;
			for(GuitarString string : strings)
			    sample += string.sample();

			StdAudio.play(sample);
		    
			for(GuitarString string : strings)
			    string.tic();

			playTime--;
		    }
		    
		} while(true);
		
		buffer.close();
	    }
	    
	    catch(FileNotFoundException ex) {
		System.out.println("Unable to open file '" + args[1] +  "'");
	    }
	    catch(Exception e) {
		System.out.println("Error reading file '" + args[1] + "'");
	    }
	}
	else { 
	    System.out.println("GuitarHero.java has two optional arguments,"
			       + " -play_from_file and then a mutually neccesary file");
	}
    }
}
