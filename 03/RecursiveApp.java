package week03;

/**
 *  Recursively provides information on a long.
 *
 * @author Mitch Abel
 */
public class RecursiveApp {

    /** the long to get information on. */
    private long n = 0;

    /**
     *  Returns the number of digits in the given long.
     * @param n the long to find the number of digits of.
     * @return how many digits the long has.
     */
    public static long digits(long n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + digits(n/10);
        }
    }

    /**
     *  Return the sum of all the digits in the given long.
     * @param n the long to find the sum of digits of.
     * @return the sum of the digits in the long.
     */
    public static long sumOfDigits(long n) {
        if (Math.abs(n) < 10) {
            return n;
        } else {
            return n%10 + sumOfDigits(n/10);
        }
    }      
}
