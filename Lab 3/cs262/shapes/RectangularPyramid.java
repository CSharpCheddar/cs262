package cs262.shapes;

/**
 * Stores information about a rectangular pyramid.
 *
 * @author Martin Mueller
 * @version 02/13/2018
 */
public class RectangularPyramid extends Solid {
    //declare instance variables
    private double length;
    private double width;
    private double height;
    //constructor; gives the class a length, width, and height
    public RectangularPyramid(double length, double width, double height) {
        super("Rectangular Pyramid");
        this.length = length;
        this.width = width;
        this.height = height;
    }
    //states the kind of solid and all instance variables
    public String toString() {
        return "Type: Rectangular Pyramid\nLength: "+length+"\nWidth: "+width+"\nHeight: "+height;
    }
    //computes the volume of the solid
    public double volume() {
        return (length*width*height)/3.0;
    }
}
