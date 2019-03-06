package week11;

/**
 *  A quick sort algorithm implementation which is able to be observed through
 *  its Soter superclass.
 *
 * @author Mitch Abel
 */
public class QuickSort extends Sorter {

    /**
     *  Create a new QuickSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Uses a pivot to sort the array in place. Anything less than the pivot
     *  is put to it's left, anything larger is put to the right. Those halves
     *  are then recursivly quick sorted.
     *
     * @param left the left most index of the array or subarray.
     * @param right the right most index of the array or subarray.
     */
    public void quickSort(int left, int right) {
        if (left < right) {
            int p = partition(left, right);
            quickSort(left, p);
            quickSort(p+1, right);
            update();
        }
    }

    /**
     *  Puts items smaller than the pivot to it's left and items larger than
     *  the pivot to the right.
     *
     * @param left the left most index of the subarray.
     * @param right the right most index of the subarray.
     * @return the hole created in the array.
     */
    public int partition(int left, int right) {
        Integer pivot = nums[left];
        int hole = left;
        int i = left+1;
        int j = right;
        while (true) {
            while (j > hole && nums[j] >= pivot) {
                j--;
            }
            if (++comparisons > 0 && j == hole) {
                break;
            }
            nums[hole] = nums[j];
            hole = j;
            while(i < hole && nums[i] < pivot) {
                i++;
            }
            if (++comparisons > 0 && i == hole) {
                break;
            }
            nums[hole] = nums[i];
            hole = i;
        }
        nums[hole] = pivot;
        return hole;
    }

    /**
     *  Allows the superclass to interact with the QuickSort method as it
     *  requires some parameters.
     */
    public void sortNums() {
        quickSort(0, nums.length-1);
    }
}
