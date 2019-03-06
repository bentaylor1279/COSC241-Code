package week08;

import java.util.*;
import java.io.File;

/**
 *  An application to generate random words based on a letter frequencies in
 *  the English language.
 *
 * @author Mitch Abel
 */
public class FrequencyGenerator implements WordGenerator {

    /** A source of randomness to use when generating words. */
    private Random random;

    /** A source of letter frequencies to use when generating words. */ 
    private float[] weights;

    /**
     *  Creates an instance of random using a seed.
     *
     * @param r the seed for the random instance.
     */
    public FrequencyGenerator(Random r) {
        random = r;
    }

    /**
     *  Reads a file with a list of letter frequencies and reads them into an
     *  array of floats.
     *
     * @param file the file of frequencies to be read into an aray.
     */
    public void readFiles(String file) {
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            int count = 0;
            
            while (s.hasNextFloat()) {
                count++;
                s.nextFloat();
            }
            this.weights = new float[count];
            
            Scanner s1 = new Scanner(f);
           
            for (int i = 0; i < weights.length; i++) {
                this.weights[i] = s1.nextFloat();
            }
        }  catch(Exception e) {
            
        }
    }

    /**
     *  Creates an index to be used for generating random words. The index is
     *  generated randomly based on the frequency of letters in the
     *  English language.
     *
     * @param weights an array of freqencies of English letters.
     * @return an index to be used in generating a random word.
     */
    public int chooseIndex(float[] weights) {
        int i = 0;
        double r = random.nextDouble();
        while (r > weights[i]) {
            r = r - weights[i];
            i++;
        }
        return i;
    }

    /**
     *  Creates a random word of length n. Each letter is based on a an index
     *  from the previous method.
     *
     * @param n the length of the word to be generated.
     * @return a random word of length n.
     */
    public String nextWord(int n) {
        readFiles("letter-frequencies.txt");
        char[] alphabet = new char['z'-'a'];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = (alphabet[chooseIndex(weights)]);
            result.append(c);
        }
        return result.toString();
    }
}
