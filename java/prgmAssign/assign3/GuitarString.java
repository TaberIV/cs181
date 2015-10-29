/*
 * GuitarString.java
 * "I pledge my honor that I have abided by the Stevens Honor System."
 * 
 * Taber McFarlin (c) 2015
 *
 */

package assign3;

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
    final double samplingRate = 44100;
    
    public GuitarString(double frequency) {
	buffer = new RingBuffer((int) Math.round(samplingRate/frequency));
    }

    public GuitarString(double[] init) {
	buffer = new RingBuffer(init.length);
	
	for(int i=0; i<init.length; i++) {
	    buffer.enqueue(init[i]);
	}
    }

    public void pluck() {
	buffer = new RingBuffer(buffer.getSize());
	
	for(int i=0; i<buffer.getSize(); i++) {
	    buffer.enqueue(Math.random() - .5);
	}
    }

    public void tic() {
	double x = buffer.dequeue();
	buffer.enqueue((x + buffer.peek())/2 * decay);
	time++;
    }

    public double sample() {
	return buffer.peek();
    }

    public int time() {
	return time;
    }
}    
