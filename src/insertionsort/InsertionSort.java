package insertionsort;

/**
 * 
 * Insertion Sort Algorithm
 * 
 * SC -> O(1);
 * 
 * TC -> O(n^2);
 * 
 */

public class InsertionSort {
  public static void main(String[] args) {

    int[] numbers = { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0, };

    insertionSort(numbers);

    for (int n : numbers) {
      System.out.println(n);
    }

  }

  private static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int item = array[i];
      int j = i - 1;

      while (j >= 0 && array[j] > item) {
        array[j + 1] = array[j--];
      }
      array[j + 1] = item;
    }
  }
}
