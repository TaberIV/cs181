/*
 * assign2.OneDimArrayProblems.java
 *
 * "I pledge my honor I have abided by the Stevens Honor System."
 *
 */

package assign2;

/**
 * OneDimArrayProblems contains some simple programing
 * problems using one dimenstional arrays
 *
 * @author Taber McFarlin
 *
 */
public class OneDimArrayProblems {

    /**
     * @param arr     non-null array of ints
     * @param min     lower bound (inclusive)
     * @param sup     upper bound (exclusive)
     * @return        true if and only if all entries in the array
     *                fall between the specified values (with min 
     *                being permitted but sup being just beyond the
     *                allowable range):
     *
     *                (forall 0<=i<arr.length)
     *                  ((min <= arr[i] && (arr[i] < sup))
     */
    public static boolean isWithinRange(int[] arr, int min, int sup){
	//Looks for elements outside range and returns false if one is found
	for(int i=0; i<arr.length; i++){
	    if((arr[i] < min) || (arr[i] >= sup)){
		return false;
	    }
	}
           
	return true;
    }


    /**
     * @param arr      non-null array of int's
     * @return         true if and only if its entries, taken as a
     *                 set, consist of all the numbers between 0 
     *                 arr.length-1 (possibly permuted according to
     *                 some arbitrary order):
     * 
     *                (forall 0<=i<arr.length) 
     *                   (exists 0<=j<arr.length) 
     *                     (arr[j]==i)
     */
    public static boolean isPermutation (int[] arr) {
        int[] arr2 = new int[arr.length];
	//Initializes arr2 to be array of 0 to arr.length - 1
	for(int i=0; i<arr.length; i++)
	    arr2[i] = i;

	/*For each element of arr looks through arr2 for a matching element,
	if none is found by the end of the loop through arr2, returns false.*/
	for(int i=0; i<arr.length; i++){
	    for(int j=0; j<arr.length; j++){
		if(arr2[j] == arr[i])
		    break;
		else if(j == arr.length-1)
		    return false;
	    }
	}
	
	return true;
    }
    
    
    /**
     * @param arr      non-null array of int's
     * @return         true if-and-only-if the sequence arr[0], 
     *                 arr[arr[0]], arr[arr[arr[0]]], ... reaches 0 
     *                 after traversing all entries in arr
     */
    public static boolean isCyclic (int[] arr) {
	if(arr.length == 0)
	    return true;
	if(!isPermutation(arr))
	    return false;
	
	int index = 0, numTrav = 0;
	do{
	    index = arr[index];
	    numTrav++;
	}while(index != 0 && numTrav < arr.length);
	
	return (numTrav == arr.length && index == 0);       
    }

    
    /**
     * @param arr      non-null array of int's
     * @return         true if-and-only-if the entries in arr are 
     *                 sorted in non-decreasing order, that is, 
     *
     *                 (forall 0<=i<arr.length-1) 
     *                   (arr[i] <= arr[i+1])
     *
     */
    public static boolean isSorted (int[] arr) {
	for(int i=0; i<arr.length-1; i++)
	    if(arr[i] > arr[i+1])
		return false;
	
	return true;
    }

    /**
     * @param arr      non-null array of int's
     * @param k        "sloppiness"
     * @return         true if-and-only-if the entries in arr are 
     *                 sorted sloppily "up to k", that is, every entry
     *                 precedes at most k smaller values and follows
     *                 at most k larger values
     *
     */
    public static boolean isSloppilySorted (int[] arr, int k) {
	int slopCount, dir;
	
	//Runs through the loop twice for each element of arr,
	//once forwards and once backwards
	for(int i=0; i<arr.length*2; i++){
	    slopCount = 0;
	    dir = (i%2 == 0) ? -1 : 1;
	    
	    //Searches backwards from i if dir is -1,
	    //searches forwards if dir is 1
	    for(int j=i/2 + dir; j>0 && j<arr.length; j+=dir) 
		if(arr[j] * dir < arr[i/2] * dir) //Swithces sign of elements
		    slopCount++;                  //if searching backwards
	    
	    if(slopCount > k)
		return false;
	}

	return true;
    }
}
