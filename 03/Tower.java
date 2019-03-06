package week03;

/**
 *  A recursive representation of a tower of blocks.
 *
 * @author Michael Albert
 */
public class Tower{

    /** The top block. */
    private char top;
    
    /** The rest of the tower. */
    private Tower rest;

    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }
    
    /**
     *  External classes can only create empty towers and manipulate
     *  them using public methods, because this constructor is
     *  private.
     * @param top the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     *  Returns true if this tower is empty, otherwise false.  Empty
     *  towers are represented with the top block being a space
     *  character.
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {
        return top == ' ';
    }
        
    /**
     *  Creates a new tower by adding the given block to the top of
     *  this tower.
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }

    /**
     *  Counts the height of the Tower, that is the number of blocks
     *  and returns this height as an int.
     * @return the height of the Tower as an int.
     */
    public int height() {
        if (isEmpty()) {
            return 0;
        } else {
            return 1 + rest.height();
        }
    }

    /**
     *  Counts the number of blocks in the Tower that are equal to a
     *  a given character.
     * @param c a character that the user wants to compare to the blocks
     * in the tower.
     * @return the number of blocks in the Tower that the given character
     * is the same as.
     */
    public int count(char c) {
        if (isEmpty()) {
            return 0;
        } else {
            if (c == top) {
                return 1 + rest.count(c);
            } else {
                return 0 + rest.count(c);
            }
        }
    }
}
