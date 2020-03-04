
/**
 * Creates identical arrays of Clocks and sorts them using different sorting algoithms.
 * The program then prints out how long each algorithm took in milliseconds.
 *
 * @author Martin Mueller
 * @version 02/28/2018
 * 
 * The largest array that can be sorted by insertion sort in
 * under 2 seconds is approximately 26,500 Clocks in size.
 * 
 * The largest array that can be sorted by selection sort in
 * under 2 seconds is approximately 22,100 Clocks in size.
 */

import java.util.Random;

public class Driver {
    public static void main(String args[]) {
        //create 2 comparable arrays for storing clocks
        int size = 22100;
        Comparable insertion[] = new Clock[size];
        Comparable selection[] = new Clock[size];
        //create a random number generator
        Random random = new Random();
        //populate the clock arrays with clocks with random time values
        for(int i=0; i<insertion.length; i++) {
            Clock clock = new Clock(random.nextInt(24), random.nextInt(60), random.nextInt(60));
            insertion[i] = clock;
            selection[i] = clock;
        }
        //sort the arrays and keep track of how long it takes for each sort to complete
        long insertionTime = System.currentTimeMillis();
        insertionSort(insertion);
        insertionTime = System.currentTimeMillis() - insertionTime;
        long selectionTime = System.currentTimeMillis();
        selectionSort(selection);
        selectionTime = System.currentTimeMillis() - selectionTime;
        //determine if both arrays were sorted in the same way and print the result
        boolean equal = true;
        for(int i=0; i<selection.length; i++) {
            if(selection[i].compareTo(insertion[i]) != 0) {
                equal = false;
                i=selection.length;
            }
        }
        System.out.println("Equal: "+equal);
        //print out how long it took to sort each array using the different algorithms in miliseconds
        System.out.println("\nInsertion Sort: "+insertionTime);
        System.out.println("\nSelection Sort: "+selectionTime);
    }
    //sorts a Comparable array using insertion sort
    public static void insertionSort(Comparable[] c) {
        //start by comparing the second element to the rest,then the third to the rest, etc....
        for(int i=1; i<c.length; i++) {
            //check to see if the element before element i is bigger than element i
            if(c[i].compareTo(c[i-1]) < 0) {
                //save the element to be inserted
                Comparable insert = c[i];
                //check to see which elements need to be moved down
                for(int j=0; j<i; j++) {
                    if(c[i].compareTo(c[j]) < 0) {
                        //move everything from the j-th spot to the (i-1)-th spot down one spot
                        for(int k=i; k>j; k--) {
                            c[k] = c[k-1];
                        }
                        //put the old i-th element in its new spot
                        c[j] = insert;
                        //quit the j for loop
                        j=i;
                    }
                }
            }
        }
    }
    //sorts a Comparable array using selection sort
    public static void selectionSort(Comparable[] c) {
        //start sorting at element i
        for(int i=0; i<c.length; i++) {
            //put in dummy values for the smallest element
            int index = i;
            Comparable smallest = c[i];
            //find the smallest element in the unsorted part of the array
            for(int j=i; j<c.length; j++) {
                if(c[j].compareTo(smallest) < 0) {
                    index = j;
                    smallest = c[j];
                }
            }
            //swap element i with the smallest found element
            c[index] = c[i];
            c[i] = smallest;
        }
    }
}
