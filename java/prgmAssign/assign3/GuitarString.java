/*
 * GuitarString.java
 * "I pledge my honor that I have abided by the Stevens Honor System."
 * 
 * Taber McFarlin (c) 2015
 *
 */

package assign3;

import java.lang.Throwable;

/**
 * Implements a virtual guitar string with Karplus-Strong algorithm
 *
 * @author  Taber McFarlin
 * @since   20151027
 *
 */
public class GuitarString {
    RingBuffer buffer;
    int time;
    final double decay = 0.996;
    double frequency;
    final int samplingRate = 44100;

    /* 
     * Creates new GuitarString with an empty buffer for given frequency
     */
    public GuitarString(double frequency) {
	buffer = new RingBuffer((int) Math.round(samplingRate/frequency));
	this.frequency = frequency;
    }

    /*
     * Creates new GuitarString with given buffer
     */
    public GuitarString(double[] init) {
	buffer = new RingBuffer(init.length);
	
	for(int i=0; i<init.length; i++) {
	    buffer.enqueue(init[i]);
	}
    }

    /*
     * Fills  buffer with random doubles from -.5  to .5
     */
    public void pluck() {
	int capacity = (int) Math.round(samplingRate/frequency);
	buffer = new RingBuffer(capacity);
	
	for(int i=0; i<capacity-1; i++) {
	    buffer.enqueue(Math.random() - .5);
	}
    }

    /*
     * Returns next element of buffer and adds the next according
     * to Karplus-Strong algorithm, and increments time.
     */
    public void tic() {
	double x;
	try {
	    x = buffer.dequeue();
	}
	catch(StackOverflowError e) {
	    x = 0;
	}
	buffer.enqueue(((x + buffer.peek())/2.0) * decay);	
	time++;
    }

    /* 
     * @return current sound to be played
     */
    public double sample() {
	return buffer.peek();
    }

    /*
     * returns number of times tic has beed called
     */
    public int time() {
	return time;
    }
}    
