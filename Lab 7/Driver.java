
/**
 * Tests all the methods in the Recursion class.
 *
 * @author Martin Mueller
 * @version 04/10/2018
 */

import java.util.*;

public class Driver {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        System.out.println(Recursion.reverse(input.next()));
        System.out.println("Enter the nth term: ");
        System.out.println(Recursion.sumSeries(input.nextInt()));
        System.out.println("Enter a number: ");
        System.out.println(Recursion.sumEvenDigits(input.nextInt()));
    }
}
