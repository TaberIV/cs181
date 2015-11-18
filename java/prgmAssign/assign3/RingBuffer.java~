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
    private boolean justAdded;
    
    public RingBuffer(int capacity) {
	buffer = new double[capacity];
	first = 0;
	last = 0;
	justAdded = false;
    }

    /*
     * If the buffer wraps aroundthe array, returns the distance
     * of
     */
    int getSize() {
	if(first == last) {
	    if(justAdded)
		return buffer.length;
	    else
		return 0;
	}
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
	justAdded = true;
    }
    
    double dequeue() {
	double x = buffer[first];
	first = (first + 1) % buffer.length;
	justAdded = false;
        return x;
    }

    double peek() {
	return buffer[first];
    }
}
