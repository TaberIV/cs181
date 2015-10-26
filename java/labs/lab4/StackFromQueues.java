/*
 * StaackFromQueues.java
 *
 * "I pledge my honor that I have abided by the Stevens Honor System"
 *
 */

package lab4;

import java.util.*;

/**
 * Creates a stack class using queues
 *
 * @author    Taber McFarlin and Corey Barnwell
 * @since     20151020
 *
 */
public class StackFromQueues{
    private Queue q1, q2;
    
    public StackFromQueues(int[] arr){
	q1 = new Queue(arr);
    }

    public StackFromQueues( ){
	this(new int[0]);
    }

    public int size(){
	return q1.size();
    }

    public void push(int num){
	q2 = new Queue();
	q2.enqueue(num);

	for(int i=0; i<this.size(); i++){
	    q2.enqueue(q1.dequeue());
	}
	
	q1 = q2;
    }

    public int pop() {
	if(this.empty())
	    throw new EmptyStackException();
	return (q1.dequeue());
    }

    public boolean empty() {
	return (this.size() == 0);
    }

    public int peek() {
	return q1.peek();
    }
}
