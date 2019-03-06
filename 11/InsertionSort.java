package week11;

/**
 *  A insertion sort algorithm implementation which is able to be observed
 *  through its Sorter superclass.
 *
 * @author Mitch Abel
 */
public class InsertionSort extends Sorter {

    /**
     *  Create a new InsertionSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class).
     *  This is done by working from left to right, with the middle value
     *  being the value to sort, the left side being the sorted side, and
     *  the right side being the unsorted side. A place is found in the left
     *  side for the value to go and then then the value pointer is shifted
     *  to the right.
     */
    public void sortNums() {
        comparisons = 0;
        Integer key;
        for (i = 1; i < nums.length; i++) {
            key = nums[i];
            for (j = i-1; j >= 0; j--) {
                if (++comparisons > 0 && nums[j] > key) {
                    nums[j+1] = nums[j];
                    nums[j] = key;
                    update();
                } else {
                    nums[j+1] = key;
                    update();
                    break;
                }
            }
        }
    }
}
