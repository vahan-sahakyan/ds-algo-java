package mergesort;

/**
 * 
 * Merge Sort Algorithm
 * 
 * SC -> O(n);
 * 
 * TC -> O(n log n);
 * 
 */

import java.util.List;
import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        ArrayList<Integer> sorted = mergeSort(numbers);
        System.out.println("random: " + numbers);
        System.out.println("sorted: " + sorted);
    }

    // divides the array recursively until single item arrays
    private static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
        int length = arr.size();
        if (length == 1) return arr;
        int middle = length >> 1;
        int ii = 0;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        while (ii < middle) left.add(arr.get(ii++));
        while (ii < length) right.add(arr.get(ii++));
        return merge(mergeSort(left), mergeSort(right), length);
    }

    // merges two already sorted arrays
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

