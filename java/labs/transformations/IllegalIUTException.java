package transformations;

public class IllegalIUTException extends IllegalArgumentException{
    public IllegalIUTException(int a, int b, int c, int d) {
	System.out.println(a + " * " + d + " - " + b + " * " + c + " = " +
			   a * d + " - " + b * c + " != 1");
    }
}