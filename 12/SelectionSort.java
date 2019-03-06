package week12;

/**
 *  A selection sort implementation which is able to be observed through
 *  its Sorter superclass.
 *
 * @author Iain Hewson
 */
public class SelectionSort extends Sorter {
    
    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using selection sort.
     */
    public void sortNums() {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = getMinIndex(i);
            Integer temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
            update();
        }
    }

    public int getMinIndex(int index) {
        Integer min = nums[index];
        int minIndex = index;
        for (int i = index; i < nums.length; i++) {
            if (++comparisons > 0 && nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        } return minIndex;
    }
}
