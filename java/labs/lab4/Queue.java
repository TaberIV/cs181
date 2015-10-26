/*
 * Queue.java
 *
 * "I pledge my honor that I have abided by the Stevens Honor System"
 *
 */

package lab4;

import java.util.*;

/**
 * Creates a queue class
 *
 * @author    Taber McFarlin and Corey Barnwell
 * @since     20151020
 *
 */
public class Queue{
    private int[] arr;
    
    public Queue(int[] arr){
	this.arr = arr;
    }

    public Queue( ){
	this(new int[0]);
    }

    public int size(){
	return arr.length;
    }

    public void enqueue(int num){
	int[] arrTemp = new int[this.size()+1];

	for(int i=0; i<this.size(); i++){
	    arrTemp[i] = arr[i];
	}

	arrTemp[this.size()] = num;
	arr = arrTemp;
    }

    public int dequeue() {
	if(this.empty())
	    throw new EmptyStackException();
	
	int num = arr[0];
	int[] arrTemp = new int[this.size()-1];

	for(int i=0; i<this.size()-1; i++)
	    arrTemp[i] = arr[i+1];

	arr = arrTemp;
	return num;
    }

    public boolean empty() {
	return (this.size() == 0);
    }

    public int peek() {
	return arr[0];
    }
}
