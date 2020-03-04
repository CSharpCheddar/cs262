
/**
 * Reads a file filled with random numbers, then prints out how many numbers it read and the average of all of them.
 *
 * @author Martin Mueller
 * @version 03/27/2018
 */

import java.util.Scanner;
import java.io.File;

public class Reader {
    public static void main(String args[]) {
        //create a Scanner
        Scanner scanner = null;
        try {
            //scan in all numbers in the specified file and keep track of them
            scanner = new Scanner(new File(args[0])).useDelimiter("&|#");
            double average = 0.0;
            int count = 0;
            while(scanner.hasNext()) {
                average += Double.parseDouble(scanner.next());
                count++;
            }
            //calculate average
            average /= count;
            //print out results
            System.out.println("Count: " + count);
            System.out.println("Average: " + average);   
        } catch(Exception e) { //catch all exceptions
            System.out.println("An error occurred");
        } finally { //close the Scanner
            scanner.close();
        }
    }
}
