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
    Ringbuffer buffer;
    int time;
    final int decay = 0.996, samplingRate = 44100;
    
    public GuitarString(double frequency) {
	buffer = new RingBuffer(Math.round(44100/frequency));
    }

    public GuitarString(double[] init) {
	buffer = new RingBuffer(init.length);
	
	for(int i=0; i<init.length; i++) {
	    buffer.enqueue(init[i]);
	}
    }

    public void pluck() {
	buffer = new RingBuffer(buffer.getSize());
	
	for(int i=0; i<buffer.getSize(); i++;) {
	    buffer.enqueue(Math.random() - .5);
	}
    }

    public void tic() {
	double x = buffer.dequeue();
	buffer.enqueue(x * buffer.peex() * decay);
	time++;
    }

    public double sample() {
	return buffer.peek();
    }

    public int time() {
	return time;
    }
}    
