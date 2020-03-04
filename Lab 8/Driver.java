
/**
 * Tests all the various methods within the StrangeContainer class.
 *
 * @author Martin A. Mueller
 * @version 04/17/2018
 */
public class Driver {
    public static void main(String args[]) {
        //create a StrangeContainer
        StrangeContainer<Integer> container = new StrangeContainer<>();
        //populate it
        container.add(12);
        container.add(22);
        container.add(81);
        container.add(52);
        container.add(11);
        container.add(3);
        container.add(4);
        //call its toString()
        System.out.println("toString() call:\n[4, 3, 11, 52, 81, 22, 12]="+container);
        //call size()
        System.out.println("Size: 7="+container.size());
        //get the element at 0
        System.out.println("Peek at 0: 4="+container.peek(0));
        //get the element at 6
        System.out.println("Peek at 6: 12="+container.peek(6));
        //delete all the elements and print them out while doing that
        System.out.print("Deleted Elements: 52 81 11 22 3 12 4=");
        for(int i=0; i<7; i++) {
            System.out.print(container.delete()+" ");
        }
        //repopulate the container
        container.add(4);
        container.add(3);
        container.add(11);
        container.add(52);
        container.add(81);
        container.add(22);
        container.add(12);
        //sort it
        container.sort();
        //print out the sorted container
        System.out.println("\nSort: [3, 4, 11, 12, 22, 52, 81]="+container);
    }
}
