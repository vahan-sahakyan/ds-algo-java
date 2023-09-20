package insertionsort;

import java.util.List;
import java.util.ArrayList;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(63, 24, 1, 5, 87, 4, 283, 99, 44, 0));
        System.out.println("random: " + numbers);
        insertionSort(numbers);
        System.out.println("sorted: " + numbers);
    }

    /**
     * @Details
     *          Insertion Sort Algorithm
     *          <ul>
     *          <li>Mutating</li>
     *          <li>Space Complexity: O(1)</li>
     *          <li>Time Complexity: O(n^2)</li>
     *          </ul>
     * @param arr ArrayList < Integer >
     * @return void
     */
    private static void insertionSort(ArrayList<Integer> arr) {
        for (int ii = 1; ii < arr.size(); ii++) {
            int item = arr.get(ii);
            int jj = ii - 1;
            while (jj >= 0 && arr.get(jj) > item) {
                arr.set(jj + 1, arr.get(jj--));
            }
            arr.set(jj + 1, item);
        }
    }
}
