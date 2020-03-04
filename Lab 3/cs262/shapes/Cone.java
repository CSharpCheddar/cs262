package cs262.shapes;

/**
 * Stores information about a cone.
 *
 * @author Martin Mueller
 * @version 02/13/2018
 */

import java.lang.Math;

public class Cone extends Solid {
    //declare the radius and height of the cone
    private double radius;
    private double height;
    //cone's constructor; initializes the instance varaibles and provides it a name
    public Cone(double radius, double height) {
        super("Cone");
        this.radius = radius;
        this.height = height;
    }
    //states the kind of solid and all instance variables
    public String toString() {
        return "Type: Cone\nRadius: "+radius+"\nHeight: "+height;
    }
    //computes the volume of the solid
    public double volume() {
        return (height/3.0)*Math.PI*Math.pow(radius, 2);
    }
}
