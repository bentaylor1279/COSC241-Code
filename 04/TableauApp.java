package week04;

/**
 * Skeleton code for an array based implementation of Young's tableau.
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
        System.out.println(TableauApp.isSetOf1toN(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if (!rowLengthsDecrease(t)) {
            return false;
        } else if (!rowValuesIncrease(t)) {
            return false;
        } else if (!columnValuesIncrease(t)) {
            return false;
        } else {
            return isSetOf1toN(t);
        }
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
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
     *  Determines if no row is longer than a preceding row.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return true if no row is longer than a preceding row, otherwise false.
     */
    public static boolean rowLengthsDecrease(int[][] t) {
        boolean decrease = false;
        for (int i = 0; i < t.length-1; i++) {
            if (t[i].length >= t[i+1].length) {
                decrease = true;
            } else {
                return false;
            }
        }
        return decrease;
    }

    /**
     *  Determines if from left to right in any row, the integers increase.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return true if the integers increase from left to right in any row,
     * otherwise false.
     */
    public static boolean rowValuesIncrease(int[][] t) {
        boolean increase = false;
        for (int i = 0; i < t.length-1; i++) {
            for (int j = 0; j < t[i].length-1; j++) {
                if (t[i][j] < t[i][j+1]) {
                    increase = true;
                } else {
                    return false;
                }
            }
        }
        return increase;
    }

    /**
     *  Determines if from top to bottom in any collumn, the integers increase.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return true if the integers increase from top to bottom in any
     * collumn, otherwise false.
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
        }
        return increase;
    }

    /**
     *  Determines if the set of integers in the Tableau are from 1 to n
     *  with n being the number of cells.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return true if the integers used are from 1 to n with n being the
     * number of cells.
     */
    public static boolean isSetOf1toN(int[][] t) {
        boolean isSet = false;
        int cells  = 0;
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


