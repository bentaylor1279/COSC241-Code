package week12;

/**
 *  Practical test 2 - Part A
 *
 *  An array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        return rowLengthsDecrease(t) && rowValuesIncrease(t) &&
            columnValuesIncrease(t) && isSetOf1toN(t);
    }

    /**
     *  Returns a string representation of a tableau.
     *
     * @param t a two-dimensional array which should be a tableau.
     *
     * @return a string representation of a tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean rowLengthsDecrease(int[][] t) {
        boolean decrease = false;
        for (int i = 0; i < t.length-1; i++) {
            if (t[i].length >= t[i+1].length) {
                decrease = true;
            } else {
                return false;
            }
        } return decrease;
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean rowValuesIncrease(int[][] t) {
        boolean increase = false;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length-1; j++) {
                if (t[i][j] < t[i][j+1]) {
                        increase = true;
                    } else {
                        return false;
                    }
            }
        } return increase;
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean columnValuesIncrease(int[][] t) {
        boolean increase = false;
        for (int i = 0; i < t.length-1; i++) {
            for (int j = 0; j < t[i+1].length; j++) {
                if (t[i][j] < t[i+1][j]) {
                    increase = true;
                } else {
                    return false;
                }
            }
        } return increase;
    }

    /**
     * Determines whether the array passed to it is valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isSetOf1toN(int[][] t) {
        boolean isSet = false;
        int cells = 0;
        int n = 1;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                cells++;
            }
        }
        while (n < cells) {
            isSet = false;
            for (int i = 0; i < t.length; i++) {
                for (int j = 0; j < t[i].length; j++) {
                    if (t[i][j] == n) {
                        isSet = true;
                    }
                }
            }
            if (!isSet) {
                return isSet;
            }
            n++;
        }
        return isSet;
    }
}
