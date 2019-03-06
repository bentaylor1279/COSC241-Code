package week11;

/**
 *  A merge sort algorithm implementation which is able to be observed
 *  through its Sorter superclass.
 *
 * @author Mitch Abel
 */
public class MergeSort extends Sorter {

    private Integer[] temp;
    
    /**
     *  Create a new MergeSort sorter witht the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
        super(nums);
        temp = new Integer[nums.length];
    }

    /**
     *  Recursivly splits the array into 2 subarrays until the size of the
     *  subarrays is size 2.
     *
     * @param left the left most index of the array or subarray.
     * @param right the right most index of the array or subarray.
     */
    public void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort (left, mid);
            mergeSort (mid + 1, right);
            merge (left, mid + 1, right);
        }
    }


    /**
     *  Stiches the sorted subarrays back together. When two arrays are put
     *  together, the resulting array will also be in order.
     *
     * @param left the left most index of the subarray.
     * @param mid the middle index of the subarray.
     * @param right the right most index of the subarray.
     */
    public void merge(int left, int mid, int right) {
        System.arraycopy(nums, left, temp, left, (right-left)+1);
        int i = left;
        int j = left;
        int k = mid;
        while (i < mid && k <= right) {
            if (temp[i] < temp[k]) {
                nums[j++] = temp[i++];
                comparisons++;
            } else {
                nums[j++] = temp[k++];
                comparisons++;
            }
        }
        while (i < mid) {
            nums[j++] = temp[i++];
        }
        while (j <= right) {
            nums[j++] = temp[k++];
        }
        update();
    }

    /**
     *  Allows the sorter class to interface with this class as the
     *  mergeSort method requires to parameters.
     */
    public void sortNums() {
        mergeSort(0, nums.length-1);
    }
}
                    
                                   
