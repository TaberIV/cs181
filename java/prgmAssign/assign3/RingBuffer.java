/*
 * RingBuffer.java
 *
 * "I pledge my honor I have abided by the Stevens Honor System."
 *
 * Taber McFarlin (c) 2015
 *
 */

package assign3;

import java.lang.Throwable;

/**
 * Implemants code for ring buffer feedback  
 * mechanism for Karplus-Strong algorithm
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
     * Where first = last, determins whether buffer is empty or full
     * based on if the last action added to the buffer or not.
     *
     * If buffer wraps around, returns distance from beggining of the
     * array to last plus the distance from first to the end of the array.
     *
     * @return number of items in the buffer
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

    /*
     * @return boolean if buffer is empty, (size = 0)
     */
    boolean isEmpty() {
	return (getSize() == 0);
    }

    /*
     * @return boolean if buffer is emptyfill, (size = capacity)
     */
    boolean isFull() {
	return (getSize() == buffer.length);
    }

    /*
     * Adds indicated value to the end of buffer and increments
     * last. If last exceeds the end of the array, it is wrapped around to 0.
     * If the array is full, an error is thrown.
     *
     * @param double x, value to be added
     */
    void enqueue(double x) {
	if(isFull())
	    throw new StackOverflowError();
	buffer[last] = x;
	last = (last + 1) % buffer.length;
	justAdded = true;
    }

    /*
     * Increments first and returns value at index first
     * BEFORE the incrementaion. If last exceeds the end of the array, 
     * it is wrapped around to 0. If the array is empty, an error is thrown.
     *
     * @return value at index first of buffer array
     */
    double dequeue() {
	if(isEmpty())
	    throw new StackOverflowError();
	double x = buffer[first];
	first = (first + 1) % buffer.length;
	justAdded = false;
        return x;
    }

    /*
     * Returns value at index first WITHOUT incrementation
     * 
     * @return value at index first of buffer array
     */
    double peek() {
	return buffer[first];
    }
}
