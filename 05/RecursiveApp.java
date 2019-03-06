package week05Practice;

public class RecursiveApp {

    public static long digits(long n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + digits(n/10);
        }
    }

    public static long sumOfDigits(long n) {
        if (Math.abs(n) < 10) {
            return n;
        } else {
            return n%10 + sumOfDigits(n/10);
        }
    }
}
