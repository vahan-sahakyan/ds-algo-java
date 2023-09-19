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
        ArrayList<Integer> sortedNumbers = mergeSort(numbers);
        System.out.println("random: " + numbers);
        System.out.println("sorted: " + sortedNumbers);
    }

    // divides the array recursively until single item arrays
    private static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
        if (arr.size() == 1) return arr;

        int mid = arr.size() >> 1;
        int i = 0;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        while (i < mid) left.add(arr.get(i++));
        while (i < arr.size()) right.add(arr.get(i++));

        return merge(mergeSort(left), mergeSort(right), arr.size());
    }

    // merges two already sorted arrays
    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, int length) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (k++ < length) {
            if (i < left.size()) {
                result.add(left.get(i++));
            } else if (j < right.size()) {
                result.add(right.get(j++));
            }
        }

        return result;
    }
}

