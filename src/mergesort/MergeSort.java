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

class MergeSort {
  public static void main(String[] args) {

    int[] numbers = { 99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0, };

    int[] sortedNumbers = mergeSort(numbers);

    for (int n : sortedNumbers) {
      System.out.println(n);
    }

  }

  // divides the array recursively until single item arrays
  private static int[] mergeSort(int[] array) {
    if (array.length == 1)
      return array;
    int mainLength = array.length;
    int middle = mainLength / 2;
    int leftLength = middle;
    int rightLength = mainLength - middle;

    int[] left = new int[leftLength];
    int[] right = new int[rightLength];

    for (int i = 0; i < leftLength; i++) {
      left[i] = array[i];
    }
    for (int i = middle, j = 0; i < mainLength; i++, j++) {
      right[j] = array[i];
    }

    return merge(mergeSort(left), mergeSort(right), mainLength);
  }

  // merges two already sorted arrays
  private static int[] merge(int[] left, int[] right, int length) {
    int[] result = new int[length];
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        result[k++] = left[i++];
      } else {
        result[k++] = right[j++];
      }
    }

    for (int l = k; l < length; l++) {
      if (i < left.length) {
        result[l] = left[i++];
      } else if (j < right.length) {
        result[l] = right[j++];
      }
    }

    return result;
  }
}
