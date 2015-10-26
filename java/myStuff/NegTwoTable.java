public class NegTwoTable{
    public static String toBinary(int num10){
        String num2 = new String();
	char bit;
	while(num10 > 0){
	    bit = (char) (num10 % 2 +48);
	    num2 = bit + num2;
	    num10 /= 2;
	}
	
	return num2;
    }

    public static void main(String[] args){
    	int sum;
	String num;
    	for(int m = 1; m < 128; m++){
	    sum = 0;
	    num = toBinary(m);

	    for(int i=0; i<num.length(); i++){
	        int bit;
	        if(num.charAt(i) == '0')
		    bit = 0;
		else if(num.charAt(i) == '1')
		    bit = 1;
		else{
		    System.out.println("Input error, enter only binary numbers.");
		    return;
	        }

	    sum += bit * Math.pow(-2 , num.length()-(i+1));
	    }
	System.out.println(m +"\t=\t" + num + "\t=\t" + sum);
	}
    }
}
