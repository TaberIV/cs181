/*
 * Stack.java
 *
 * "I pledge my honor that I have abided by the Stevens Honor System"
 *
 */

package lab4;

import java.util.*;

/**
 * Creates a stack class
 *
 * @author    Taber McFarlin and Corey Barnwell
 * @since     20151020
 *
 */
public class Stack{
    private int[] arr;
    
    public Stack(int[] arr){
	this.arr = arr;
    }

    public Stack( ){
	this(new int[0]);
    }

    public int size(){
	return arr.length;
    }

    public void push(int num){
	int[] arrTemp = new int[this.size()+1];

	for(int i=0; i<this.size(); i++){
	    arrTemp[i+1] = arr[i];
	}

	arrTemp[0] = num;
	arr = arrTemp;
    }

    public int pop() {
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
