package week05Practice;

import java.util.Random;

public class Coins{

    public static final boolean HEADS = true;
    public static final boolean TAILS = false;
	
    private boolean[] coins;
	
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    public Coins(String c) {
        coins = new boolean[c.length()];
        for (int i = 0; i < c.length(); i++) {
            if (c.substring(i,i+1).equals("H")) {
                coins[i] = HEADS;
            } else {
                coins[i] = TAILS;
            }
        }
    }

    public Coins(int length) {
        coins = new boolean[length];
        Random flip = new Random();
        for (int i = 0; i < length; i++) {
            int result = flip.nextInt(2);
            if (result == 1) {
                coins[i] = HEADS;
            } else {
                coins[i] = TAILS;
            }
        }
    }

    public int countHeads() {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i]) {
                count++;
            }
        } return count;
    }

    public String toString() {
        String coinFlips = "";
        for (int i = 0; i < coins.length; i++) {
            if (coins[i]) {
                coinFlips = coinFlips + "H";
            } else {
                coinFlips = coinFlips + "T";
            }
        } return coinFlips;
    }

    public int countRuns() {
        int runs = 1;
        for (int i = 0; i < coins.length-1; i++) {
            if (coins[i] != coins[i+1]) {
                runs++;
            }
        } return runs;
    }
}
