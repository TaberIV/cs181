/*
 * BaseNegTwoConvert.java
 *
 * "I pledge my honor that I have avided by the Stevens Honor System."
 *
 */

/**
 * Converts a base negitive two number to decimal.
 * 
 * @author    Taber McFarlin
 * @version   1.0
 * @since     2015922
 */
public class BaseNegTwoConvert{
    /**
     * Converts string of binary digits to decimal int
     * equal to the string in base negitive 2
     *
     * args should contain only 1 string that contains only 1s and 0s
     * 
     * @return base ten number equivalent to base negitive two string
     * 
     */
    public static void main(String[] args){
	if(args.length != 1){
	    System.out.println("Input error: BaseNegTwoConvert takes exactly one argument");
	    return;
	}
	
	int sum = 0;
	
	for(int i=0; i<args[0].length(); i++){
	    int bit;
	    if(args[0].charAt(i) == '0')
		bit = 0;
	    else if(args[0].charAt(i) == '1')
		bit = 1;
	    else{
		System.out.println("Input error: enter only biinary numbers.");
		return;
	    }

	    sum += bit * Math.pow(-2 , args[0].length()-(i+1));
	}
	System.out.println(sum);
    }
}
