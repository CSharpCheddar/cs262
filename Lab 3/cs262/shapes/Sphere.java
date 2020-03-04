package cs262.shapes;

/**
 * Stores information about a sphere.
 *
 * @author Martin Mueller
 * @version 02/13/2018
 */

import java.lang.Math;

public class Sphere extends Solid {
    //the radius of the sphere
    private double radius;
    //constructor gives the sphere a name
    public Sphere(double radius) {
        super("Sphere");
        this.radius = radius;
    }
    //states the kind of solid and all instance variables
    public String toString() {
        return "Type: Sphere\nRadius: "+radius;
    }
    //computes the volume of the solid
    public double volume() {
        return (4.0/3.0)*Math.PI*Math.pow(radius, 3);
    }
}
