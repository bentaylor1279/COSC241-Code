package week11;

/**
 *  A selection sorting algorithm implementation which is able to be observed
 *  through its Sorter superclass.
 *
 * @author Mitch Abel
 */
public class SelectionSort extends Sorter {

    /**
     *  Create a new SelectionSort sorter with the given intergers to sort.
     *
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Itterates through the given array of numbers from a given starting
     *  point and returns the index of the smallest item in the array.
     *
     * @param array the array of numbers to work on.
     * @param index the starting point to work from.
     * @return the index of the smallest item in the array.
     */
    public int getMinIndex(Integer[] array,int index) {
        Integer min = array[index];
        int minIndex = index;
        for (int i = index; i < array.length; i++) {
            if (++comparisons > 0 && array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     *  Sorts the integers (which are stored in the parent Sorter class).
     *  This is done by finding the smallest item in the list and swap it
     *  with the first item in the list, then find the next smallest and
     *  swap it with the second item in the list and so on until the list
     *  is sorted.
     */
    public void sortNums() {
        Integer temp;
        int newIndex;
        for (i = 0; i < nums.length; i++) {
            temp = nums[i];
            newIndex = getMinIndex(nums, i);
            nums[i] = nums[newIndex];
            nums[newIndex] = temp;
            update();
        }
    }
}

