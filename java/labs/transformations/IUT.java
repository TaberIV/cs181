package transformations;

import java.awt.Point;

public class IUT {
    private int a, b, c, d;

    public IUT(int a, int b, int c, int d) {
	if (a*d - b*c == 1) {
	    this.a = a;
	    this.b = b;
	    this.c = c;
	    this.d = d;
	}
	else
	    throw new IllegalIUTException(a, b, c, d);
    }

    public IUT() {
	this(1, 0, 0, 1);
    }

    public int getA() { return a; }
    public int getB() { return b; }
    public int getC() { return c; }
    public int getD() { return d; }

    public String toString() {
	return "{" + a + ", " + b + "}" +
	    " \n{" + c + ", " + d + "}";
    }

    public boolean equals(IUT other) {
	return (a == other.getA() && b == other.getB() && c == other.getC() && d == other.getD());
    }

    public IUT invert() {
	return new IUT(d, -b, -c, a);
    }

    public static IUT invert(IUT iut) {
	return iut.invert();
    }

    public IUT compose(IUT other) {
	return new IUT(a * other.getA() + b * other.getC(), a * other.getB() + b * other.getD(),
		       c * other.getA() + d * other.getC(), c * other.getB() + d * other.getD());
    }

    public static IUT compose(IUT left, IUT right) {
	return left.compose(right);
    }

    public Point applyTo(Point p) {
	return new Point(a * p.x + b * p.y, c * p.x + d * p.y);
    }

    public static Point apply(IUT iut, Point p) {
	return iut.applyTo(p);
    }

    public static void main(String[] args) {
	IUT matrix = new IUT(), matrix2;
	System.out.println("a: " + matrix.getA());
	System.out.println("b: " + matrix.getB());
	System.out.println("c: " + matrix.getC());
	System.out.println("d: " + matrix.getD());
	System.out.println(matrix);
	System.out.println(matrix.equals(new IUT(1, 0, 0, 1)));
	System.out.println();
	matrix2 = new IUT(2, 3, 1, 2);
	System.out.println(matrix2);
	System.out.println(matrix2.equals(new IUT()));
	System.out.println(matrix.invert());
	System.out.println(matrix2.invert());
	System.out.println(matrix.compose(matrix2));
	System.out.println(IUT.compose(matrix2, matrix));
	System.out.println(matrix.applyTo(new Point(1, 0)));
	System.out.println(IUT.apply(matrix2, new Point(3, 7)));
	System.out.println();
	matrix = new IUT(2, 3, 1, 5);
    }
}
