package cs262.shapes;

/**
 * Stores information about a rectangular cuboid.
 *
 * @author Martin Mueller
 * @version 02/13/2018
 */
public class RectangularCuboid extends Solid {
    //declare instance variables
    protected double length;
    protected double width;
    protected double height;
    //constructor; gives the class a length, width, and height
    public RectangularCuboid(String name, double length, double width, double height) {
        super(name);
        this.length = length;
        this.width = width;
        this.height = height;
    }
    //states the kind of solid and all instance variables
    public String toString() {
        return "Type: Rectangular Cuboid\nLength: "+length+"\nWidth: "+width+"\nHeight: "+height;
    }
    //computes the volume of the solid
    public double volume() {
        return length*width*height;
    }
}
