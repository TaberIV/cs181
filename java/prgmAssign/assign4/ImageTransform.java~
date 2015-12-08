/*
 *
 * assign4/ImageTransform.java
 * (c) 2008--15
 *
 */

package assign4;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * The ImageTransform class represents a warping image transform.
 *
 * @author Antonio R. Nicolosi
 * @author Stan Rosenberg
 */

public class ImageTransform {
    /**
     * pixels of the source image (in row-major order)
     */
    int[] srcPixels;

    /**
     * width of the source image
     */
    int width;
    /**
     * height of the source image
     */
    int height;

    /**
     * control point for the warping
     */
    Point controlPt, shiftPt;

    /**
     * Vanilla constructor for the ImageTransform class 
     */
    public ImageTransform(int[] srcPixels, int width, int height, 
			  Point controlPt, Point shiftPt) {
	this.srcPixels = srcPixels;     // scan-line is width-many pixels
	this.width = width;
	this.height = height;
   	this.controlPt = controlPt;
	this.shiftPt = shiftPt;
    }

    /**
     * The transform method implements the high-level warping logic
     *
     * @return int[] containing the pixels of the warped image.  
     *         Notice that the scan-line for the warped image is the
     *         same as for the original image, that is,
     *         this.width-many pixels.
     */
    public int[] transform() {
	/*
	 * Recall from the assignment handout how the warping works:
	 * The image is split into 4 quadrants (rectangles with the
	 * same dimension). The control point defines 4
	 * quadrilaterals. (Each quadrilateral has one vertex
	 * corresponding to the control points. The remaining vertices
	 * correspond to point on the border of the image, and are the
	 * same as the vertices for the corresponding quadrant.)  For
	 * each quadrant, we invoke warpRegion which maps the
	 * quadrilateral into the rectangle.
	 */

	// create the destination pixel array

	// YOUR CODE HERE
	int[] dstPixels = new int[srcPixels.length];

	// Quadrant 1

	// YOUR CODE HERE
	Rectangle r = new Rectangle((int) shiftPt.getX(), (int) shiftPt.getY());
	Point nw = r.getLocation(),
	    ne = new Point((int) (r.getX() + r.getWidth()), (int) r.getY()),
	    sw = new Point((int) r.getX(), (int) (r.getY() + r.getHeight())),
	    se = controlPt;
	warpRegion(dstPixels, r, nw, ne, sw, se);
	// Quadrant 2

	// YOUR CODE HERE
	r = new Rectangle((int) shiftPt.getX(), 0,
			  width - (int) shiftPt.getX(), (int) shiftPt.getY());
	nw = r.getLocation();
	ne = new Point((int) (r.getX() + r.getWidth()), (int) r.getY());
	sw = controlPt;
	se = new Point((int) (r.getX() + r.getWidth()),(int) (r.getY() + r.getHeight()));
	warpRegion(dstPixels, r, nw, ne, sw, se);
	// Quadrant 3

	// YOUR CODE HERE
	r = new Rectangle(0, (int) shiftPt.getY(),
			  (int) shiftPt.getX(), height - (int) shiftPt.getY());
	nw = r.getLocation();
	ne = controlPt;
	sw = new Point((int) r.getX(), (int) (r.getY() + r.getHeight()));
	se = new Point((int) (r.getX() + r.getWidth()),(int) (r.getY() + r.getHeight()));
	warpRegion(dstPixels, r, nw, ne, sw, se);
	// Quadrant 4

	// YOUR CODE HERE
	r = new Rectangle((int) shiftPt.getX(), (int) shiftPt.getY(),
			  width - (int) shiftPt.getX(), height - (int) shiftPt.getY());
	nw = controlPt;
	ne = new Point((int) (r.getX() + r.getWidth()), (int) r.getY());
	sw = new Point((int) r.getX(), (int) (r.getY() + r.getHeight())); //
	se = new Point((int) (r.getX() + r.getWidth()),(int) (r.getY() + r.getHeight()));
	warpRegion(dstPixels, r, nw, ne, sw, se);
	// Return the result of warping transformation

	// YOUR CODE HERE
	return dstPixels;
    }

    /**
     * The warpRegion method performs the actual image warping
     * transformation.
     * 
     * @param dstPixels   int[] where the warped image is being stored 
     * @param r           Rectangle defining the (logical) quadrant
     *                    within the destination pixels that is to be
     *                    computed by this invocation of the method
     * @param nw          North-west (upper-left) corner of the
     *                    quadrilater in the original image that is
     *                    being warped
     * @param ne          North-east (upper-right) corner of the
     *                    quadrilater in the original image that is
     *                    being warped
     * @param sw          South-west (lower-left) corner of the
     *                    quadrilater in the original image that is
     *                    being warped
     * @param se          South-east (lower-right) corner of the
     *                    quadrilater in the original image that is
     *                    being warped
     */
    protected void warpRegion(int[] dstPixels, Rectangle r, 
			      Point nw, Point ne, Point sw, Point se) {
	System.out.println("Warping quadrilateral at ");
	System.out.println(nw);
	System.out.println(ne);
	System.out.println(sw);
	System.out.println(se);
	System.out.println("into rectangle");
	System.out.println(r);
     
	// YOUR CODE HERE	
	double alpha, beta, X, Y;
	for(int y = 0; y < r.height; y++) {
	    for(int x = 0; x < r.width; x++) {
		alpha = ((double) x) / r.width;
		beta = ((double) y) / r.height;
		X = nw.getX() + (ne.getX() - nw.getX()) * alpha
		    + (sw.getX() - nw.getX()) * beta
		    + (nw.getX() - ne.getX() + se.getX() - sw.getX()) * alpha * beta;
		Y = nw.getY() + (ne.getY() - nw.getY()) * alpha
		    + (sw.getY() - nw.getY()) * beta
		    + (nw.getY() - ne.getY() + se.getY() - sw.getY()) * alpha * beta;
		int a = (int) r.getX(),
		    b = (int) r.getY();
		dstPixels[(x + a) + (y + b) * width] = getPixel((int) X, (int) Y);
	    }
	}
    }

    /**
     * Return the pixel at (x,y)
     */
    public int getPixel(int x, int y) {
	return srcPixels[x + y * width];
    }

    /** 
     * Better version of the getPixel method with color interpolation 
     * (extra-credit 1).
     */
    public int getPixel(double x, double y) {
	/* 
	 * The idea of color interpolation is the following.  Say that
	 * you want to access the fractionary pixel at coordinates
	 * (3.7,4.4).  The default implementation (no color
	 * interpolation, see below) just truncates things and get the
	 * pixel at (3,4).  This is unsatisfactory, because we are
	 * loosing the information encoded in the fractional part: in
	 * particular, the pixel we wanted had more overlap (42%) with
	 * (4,4) than with (3,4) (18%).
         *
         * Thresholdizing the "fractionary" pixel so that it agrees
         * with the "actual" pixel that maximizes overlap is a better
         * option than the default implementation, but it still is not
         * very "smooth".  Instead, color interpolation averages the
         * four real pixels that have overlap with the fractionary
         * pixel (in the example, these are (3,4), (4,4), (3, 5), and
         * (4,5)), weighting them by their relative overlap ratio
         * (respectively 18%, 42%, 12%, and 28%).
         *
         * A complication with interpolating pixels arises because of
         * the way colors are encode as Java int's.  In the RGB model,
         * the color of each pixel is described by three 8-bit
         * unsigned numbers, respectively for the red, green, and blue
         * components of the color (hence the name).  These three
         * 8-bit unsigned are packed together into a Java int as
         * follows: the "blue" byte is stored in the least-significant
         * 8 bits of the int; the "green" byte is stored in the 8 bits
         * immediately to the left; and the "red" byte is stored in
         * the 8 bits further to the left.  (The 8 most-significant
         * bits of the int do not matter under the RGB color model.)
         * 
         * So in order to do color interpolation, you will have to do
         * bitwise manipulations to get to the right values; scale
         * them by the corresponding weights, yielding a
         * floating-point value; convert back to whole numbers; and
         * pack the three components back into the int.  You might
         * want to define a helper class (or at least some helper
         * static methods) for carrying out this "color arithmetic".
	 * 
	 */
	int[] pixels = new int[4];
	pixels[0] = getPixel((int) x, (int) y);
	if (x < width - 1 && y < height - 1) {
	    pixels[1] = getPixel((int) x + 1, (int) y);
	    pixels[2] = getPixel((int) x, (int) y + 1);
	    pixels[3] = getPixel((int) x + 1, (int) y + 1);
	}
	else if (x < width - 1){
	    pixels[1] = getPixel((int) x + 1, (int) y);
	    pixels[2] = getPixel((int) x, (int) y);
	    pixels[3] = getPixel((int) x + 1, (int) y);
	}
	else if (y < height - 1){
	    pixels[1] = getPixel((int) x, (int) y);
	    pixels[2] = getPixel((int) x, (int) y + 1);
	    pixels[3] = getPixel((int) x, (int) y + 1);
	}
	else {
	    pixels[1] = getPixel((int) x, (int) y);
	    pixels[2] = getPixel((int) x, (int) y);
	    pixels[3] = getPixel((int) x, (int) y);
	}
	
	int pixel = 0;
	double n, m;

	for(int i = 0; i < 4; i++) {
	    n = x - (int) x;
	    if (i % 2 == 1)
		n = -1 * (1 - n);
	    m = y - (int) y;
	    if (i > 1)
		m = -1 * (1 - m);

	    pixel = pixelAdd(pixel, pixelMult(pixels[i], n * m));
	}

	return pixel;
	//Default implementation is no interpolation.	
	//return getPixel ((int) x, (int) y);
    }
    static int pixelAdd(int p1, int p2) {
	int pixel = 0, pixel2;
	
	pixel += (p1 & 0xFF0000) + (p2 & 0xFF0000);
	if (pixel > 0xFF0000)
	    pixel = 0xFF0000;
	
	pixel2 = (p1 & 0x00FF00) + (p2 & 0x00FF00);
	if (pixel2 > 0x00FF00)
	    pixel2 = 0x00FF00;
	pixel += pixel2;
	
	pixel2 = (p1 & 0x0000FF) + (p2 & 0x0000FF);
	if (pixel2 > 0x0000FF)
	    pixel2 = 0x0000FF;
	pixel += pixel2;
	return pixel;
    }
	     
    static int pixelMult(int pixel, double mul) {
	int newPixel = 0;
	int[] colors = new int[3];

	for (int i = 0; i < 3; i++) {
	    colors[i] = (int) (pixel / Math.pow(16, 4 - 2*i));
	    colors[i] = (int) (colors[i] * mul);
	    newPixel += colors[i] * Math.pow(16, 4 - 2*i);
	}

	return newPixel;
    }
}
