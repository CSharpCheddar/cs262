
/**
 * Tests the instance methods in the Stats class.
 *
 * @author Martin Mueller
 * @version 02/07/2018
 */

import java.util.Random;
import java.lang.Math;

public class StatsDriver {
    
    public static void main(String[] args) {
        //generate an integer array of length 20 and
        //populate it with "random" values
        int[] array = new int[20];
        Random random = new Random(2625);
        System.out.println("Array Values:");
        for(int i=0; i<array.length; i++) {
            array[i] = random.nextInt(86) + 10;
            if((i+1)%5 == 0) {
                System.out.println(array[i]+" ");
            } else {
                System.out.print(array[i]+", ");
            }
        }
        //create a new stats object, then pass in the "random" array
        Stats stats = new Stats(array);
        //this string stores the names of the failed cases
        String failedCases = "Incorrect Values:";
        //test the Stats class
        //check the average
        double average = stats.average();
        System.out.println("Average: "+average);
        if(Math.abs(average - 49.45) > 0.01) {
            failedCases += " Average;";
        }
        //check the maximum
        int max = stats.max();
        System.out.println("Maximum Value: "+max);
        if(max != 93) {
            failedCases += " Maximum;";
        }
        //check the minimum
        int min = stats.min();
        System.out.println("Minimum Value:"+min);
        if(min != 10) {
            failedCases += " Minimum;";
        }
        //check the standard deviation
        double standardDeviation = stats.standardDeviation();
        System.out.println("Standard Deviation: "+standardDeviation);
        if(Math.abs(standardDeviation - 25.10) > 0.01) {
            failedCases += " Standard Deviation;";
        }
        //check the median
        double median = stats.median();
        System.out.println("Median: "+median);
        if(Math.abs(median - 45.5) > 0.01) {
            failedCases += " Median;";
        }
        //print an error message if there were any failed cases
        if(!failedCases.equals("Incorrect Values:")) {
            System.out.print("\n"+failedCases);
        }
    }
}
