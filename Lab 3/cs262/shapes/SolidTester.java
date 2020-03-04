package cs262.shapes;


/**
 * Tests all of the other classes in this package.
 *
 * @author Martin Mueller
 * @version 02/13/2018
 */
public class SolidTester {
    public static void main(String args[]) {
        //create a bunch of shapes
        Sphere sphere1 = new Sphere(8);
        Sphere sphere2 = new Sphere(10);
        RectangularCuboid rectangularCuboid = new RectangularCuboid("Rectangular Cuboid", 5, 4, 3);
        Cube cube1 = new Cube(10);
        Cube cube2 = new Cube(5);
        Cone cone1 = new Cone(3, 5);
        Cone cone2 = new Cone(8, 2);
        RectangularPyramid rectangularPyramid = new RectangularPyramid(5, 10, 4);
        //store the shapes in a Solid array
        Solid array[] = new Solid[] {
            sphere1, sphere2, rectangularCuboid, cube1, cube2, cone1, cone2, rectangularPyramid
        };
        //run the volume and toString methods in each Solid
        for(Solid solid : array) {
            System.out.println(solid);
            System.out.println("Volume: "+solid.volume()+"\n");
        }
    }
}
