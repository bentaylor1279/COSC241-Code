package week11;

/**
 *  A heap sort algorithm implementation which is able to be observed through
 *  its Sorter superclass.
 *
 * @author Mitch Abel
 */
public class HeapSort extends Sorter {

    /**
     *  Create a new HeapSort sorter with the given integers to sort.
     *
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Turns the array into a heap data structure. Then the roots of the heap
     *  are sent to the bottom and returned, then the the heap is reorganised.
     *  the result is the values of the heap being returned in order.
     */
    public void sortNums() {
        heapify();
        comparisons = 0;
        for (int i = nums.length-1; i > 0; i--) {
            swap(0, i);
            siftDown(0, i);
        }
    }

    /**
     *  Converts the array of Integers into a heap data structure.
     *
     */
    public void heapify() {
        for (int i = (nums.length-1)/2; i >= 0; i--) {
            siftDown(i, nums.length);
        }
    }

    /**
     *  Takes the root and checks if either of its childern are bigger than it.
     *  If they are then they are swapped, the former root is then recursivly
     *  checked against its children to make sure it is in the right place in
     *  the heap.
     *
     * @param s the number to check against its children.
     * @param size the size of the array.
     */
    public void siftDown(int s, int size) {
        int largerIndex = getLargerChildIndex(s, size);
        if (largerIndex != -1) {
            swap(s, largerIndex);
            siftDown(largerIndex, size);
        }
        update();
    }

    /**
     *  Checks if either of the given index's children are larger than it.
     *  If they are the index of the largest child is returned. If neither are
     *  then -1 is returned.
     *
     * @param index the index to check against its children.
     * @param size the size of the array.
     * @return the index of the larger child if there is one, else -1.
     */
    public int getLargerChildIndex(int index, int size) {
        int l = 2*index + 1;
        int r = 2*index + 2;
        if (++comparisons > 0 && r < size && nums[r] > nums[index] &&
            nums[r] > nums[l]) {
            return r;
        }
        if (++comparisons > 0 && l < size && nums[l] > nums[index]) {
            return l;
        }
        return -1;
    }

    /**
     *  Swaps two Integers in the array.
     *
     * @param x the first item to be swapped.
     * @param y the second item to be swapped.
     */
    public void swap(int x, int y) {
        i = x;
        j = y;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        update();
    }
}
    
    

    
