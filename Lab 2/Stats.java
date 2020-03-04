
/**
 * Computes stats about the data passed into the constructor.
 *
 * @author Martin Mueller
 * @version 02/07/2018
 */

import java.util.Arrays;
import java.lang.Math;

public class Stats {
    //declare an instance variable array
    private int[] array;
    //make a deep copy of the given array, then sort the deep copy
    public Stats(int[] array) {
        this.array = new int[array.length];
        for(int i=0; i<array.length; i++) {
            this.array[i] = array[i];
        }
        Arrays.sort(this.array);
    }
    //returns the average of all of the values in the array
    public double average() {
        double average = 0;
        for(int i : array) {
            average += i;
        }
        average /= array.length;
        return average;
    }
    //returns the maximum value in the array
    public int max() {
        return array[array.length-1];
    }
    //returns the minimum value in the array
    public int min() {
        return array[0];
    }
    //returns the standard deviation of the numbers in the array
    public double standardDeviation() {
        double answer = 0;
        double average = average();
        for(int x : array) {
            answer += Math.pow(x-average, 2);
        }
        answer /= array.length;
        answer = Math.sqrt(answer);
        return answer;
    }
    //returns the median value in the array
    public double median() {
        double median = 0;
        if(array.length%2 == 0) {
            median = (array[(array.length/2)-1]+array[array.length/2])/2.0;
        } else {
            median = array[(array.length/2)];
        }
        return median;
    }
}
