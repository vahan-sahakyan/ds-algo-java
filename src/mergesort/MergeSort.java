package mergesort;

import java.util.List;
import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        ArrayList<Integer> sorted = mergeSort(numbers);
        System.out.println("random: " + numbers);
        System.out.println("sorted: " + sorted);
    }

    /**
     * @Details
     *          Merge Sort Algorithm
     *          <ul>
     *          <li>Non-Mutating</li>
     *          <li>Space Complexity: O(n)</li>
     *          <li>Time Complexity: O(n log n)</li>
     *          </ul>
     * @param array ArrayList
     * @return void
     * @Description
     *              divides the array recursively until single item arrays
     */
    private static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        int length = array.size();
        if (length == 1) return array;
        int middle = length >> 1;
        int ii = 0;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        while (ii < middle) left.add(array.get(ii++));
        while (ii < length) right.add(array.get(ii++));
        return merge(mergeSort(left), mergeSort(right), length);
    }

    /**
     * @param left   ArrayList
     * @param right  ArrayList
     * @param length int
     * @return ArrayList
     * @Description
     *              merges two arrays by sorting
     */
    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, int length) {
        ArrayList<Integer> result = new ArrayList<>();
        int ii = 0;
        int jj = 0;
        while (ii < left.size() && jj < right.size()) {
            if (left.get(ii) < right.get(jj)) {
                result.add(left.get(ii++));
            } else {
                result.add(right.get(jj++));
            }
            --length;
        }
        while (length != 0) {
            if (ii < left.size()) {
                result.add(left.get(ii++));
            } else {
                result.add(right.get(jj++));
            }
            --length;
        }
        return result;
    }
}
