/*
 * RingBuffer.java
 *
 * "I pledge my honor I have abided by the Stevens Honor System."
 *
 * Taber McFarlin (c) 2015
 *
 */

package assign3;

/**
 * Implemants code for ring buffer feedback  
 * mechanism from Karplus-Strong algorithm
 * 
 * @author Taber McFarlin
 * @since 20151027
 *
 */
public class RingBuffer {
    private double[] buffer;
    private int first, last;
    
    public RingBuffer(int capacity) {
	buffer = new double[capacity];
	first = 0;
	last = -1;
    }

    int getSize() {
	return Math.abs(first - (last + 1));
    }

    boolean isEmpty() {
	return (first == last);
    }
    
    boolean isFull() {
	return (((last + 1) % buffer.length) == first);
    }
    
    void enqueue(double x) {
	if(!isFull()) {
	    last = (last + 1) % buffer.length;
	}
	else {
	    //Throw some error
	}
	buffer[last] = x;
    }
    
    double peek() {
	return buffer[first];
    }
    
    double dequeue() {
	if(!isEmpty()) {
	    first = (first + 1) % buffer.length;
	}
	else {
	    //Throw some error
	}
	return buffer[first - 1];
    }
}
