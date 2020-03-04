package cs262.shapes;

/**
 * Write a description of class Cube here.
 *
 * @author Martin Mueller
 * @version 02/13/2018
 */
public class Cube extends RectangularCuboid {
    //constructor; makes a rectangular cuboid with
    //equal side lengths (a cube)
    public Cube(double length) {
        super("Cube", length, length, length);
    }
    //list all of the instance variables that are relevant to this class
    public String toString() {
        return "Type: Cube"+"\nLength: "+length;
    }
}
