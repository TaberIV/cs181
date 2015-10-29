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
	last = 0;
    }

    int getSize() {
	if((first == last) && buffer[first] == Float.NaN)
	    return 0;
	else if (first < last)
	    return (last - first);
	else
	    return last + buffer.length - first + 1;
    }

    boolean isEmpty() {
	return (getSize() == 0);
    }
    
    boolean isFull() {
	return (getSize() == buffer.length);
    }
    
    void enqueue(double x) {
	buffer[last] = x;
	last = (last + 1) % buffer.length;
    }
    
    double dequeue() {
	double x = buffer[first];
	buffer[first] = Float.NaN;
	first = (first + 1) % buffer.length;
        return x;
    }

    double peek() {
	return buffer[first];
    }
}
