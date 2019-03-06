package week08;

import java.util.*;
import java.io.File;

/**
 *  An application to generate random words based on the frequencies of letters
 *  following the previous letter.
 *
 * @author Mitch Abel
 */
public class DigramGenerator implements WordGenerator {

    /** A source of randomess to use when generating words. */
    private Random random;

    /** A source of first letters as they occur from most common to least common
     *  in the English language. */
    private String firstLetters;

    /** A source of letters that follow a previous letter from most common to
     *  least common. */
    private String[] strings;

    /**
     *  Creates an instance of random using a seed.
     *
     * @param r the seed for the random instance.
     */
    public DigramGenerator(Random r) {
        random = r;
    }

    /**
     *  Reads a file of letters into a String.
     *
     * @param file the file of letters to read from.
     */
    public void readFilesToString(String file) {
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            StringBuilder result = new StringBuilder();

            while (s.hasNextLine()) {
                result.append(s.nextLine());
            }
            firstLetters = result.toString();
        } catch(Exception e) {

        }
    }

    /**
     *  Reads a file of lines of letters into an Array of Strings with each
     *  element of the Array being a String of one of the lines from the file.
     *
     * @param file the file of lines of letters to read from.
     */
    public void readFilesToArray(String file) {
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            int count = 0;

            while (s.hasNextLine()) {
                count++;
                s.nextLine();
            }
            strings = new String[count];

            Scanner s1 = new Scanner(f);
            int index = 0;
            while (s1.hasNextLine()) {
                strings[index] = s1.nextLine().toString();
                index++;
            }
        } catch(Exception e) {

        }
    }

    /**
     *  Creates a random word of length n. The first letter is picked randomly
     *  from a String of letters with the more common first letters of words
     *  being more prevelent in the String. The subsequent letters are picked
     *  based on how commonly the occur following the previous letter in the
     *  English language.
     *
     * @param n the length of the word to be generated.
     * @return a random word of length n.
     */
    public String nextWord(int n) {
        readFilesToString("first-letters.txt");
        readFilesToArray("continuations.txt");
        
        StringBuilder result = new StringBuilder();
        
        int r = random.nextInt(firstLetters.length());
        char nextLetter = firstLetters.charAt(r);
        result.append(nextLetter);
        n--;
        
        while (n > 0) {
            int index = nextLetter - 'a';
            r = random.nextInt(strings[index].length());
            nextLetter = strings[index].charAt(r);
            result.append(nextLetter);
            n--;
        }
        return  result.toString();
    }
}
