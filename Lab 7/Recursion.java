
/**
 * Contains several recursive methods whose descriptions are above them.
 *
 * @author Martin Mueller
 * @version 04/10/2018
 */

public class Recursion {
    //reverses a given string
    public static String reverse(String str) {
        if (str.length() == 0) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
    //gives the nth term of the series 1/(2^n)
    public static double sumSeries(int n) {
        if(n == 0) {
            return 0;
        }
        return (1/Math.pow(2,n-1)) + sumSeries(n-1);
    }
    //returns the sum of even digits in any given number
    public static int sumEvenDigits(int n) {
        if(n < 10) {
            if(n%2 == 0) {
                return n;
            }
            return 0;
        }
        if((n%10)%2 == 0) {
            return (n%10) + sumEvenDigits(n/10);
        }
        return sumEvenDigits(n/10);
    }
}
