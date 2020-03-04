
/**
 * Writes a file filled with random numbers based on user specifications.
 *
 * @author Martin Mueller
 * @version 03/27/2018
 */

import java.util.Random;
import java.io.PrintWriter;

public class Writer {
    public static void main(String args[]) {
        //make a PrintWriter
        PrintWriter writer = null;
        try {
            //make or overwrite file
            writer = new PrintWriter(args[0]);
            //get amount of random numbers
            int num = Integer.parseInt(args[1]);
            //write them to the file
            Random random = new Random(152);
            for(int i=1; i<=num; i++) {
                if(i%5 != 0) {
                    writer.print(random.nextInt(1000) + 1);
                    if(i != num) {
                        writer.print("&");
                    } else {
                        writer.print("#");
                    }
                } else {
                    writer.print(random.nextInt(1000) + 1);
                    if(i != num) {
                        writer.println("#");
                    } else {
                        writer.print("#");
                    }
                }
            }
        } catch (Exception e) { //catch all exceptions that could occur
            System.out.println("An error occurred");
        } finally { //close the PrintWriter
            writer.close();
        }
    }
}
