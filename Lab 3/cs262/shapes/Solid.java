
package cs262.shapes;

/**
 * Write a description of class Solid here.
 *
 * @author Martin Mueller
 * @version 02/13/2018
 */

public class Solid {
    //the name of the shape
    private String name;
    //constructor; initializes name
    public Solid(String name) {
        this.name = name;
    }
    //states the kind of solid and all instance variables
    public String toString() {
        return "Type: Solid";
    }
    //gets the name of the solid
    public String getName() {
        return name;
    }
    //computes the volume of the solid
    public double volume() {
        return -1;
    }
}
