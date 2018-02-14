/**
 * @author chakkac5 creating the entry point and all the methods to be used for
 *         testing each class
 */
public class Main {

  public static void main(String[] args) {

    // test Merge Sort
    TestSorting.mergeSort(500000);

    // test Quick Sort
    TestSorting.quickSort(500000);

    // test Quick Sort Iterative
    TestSorting.quickSortIterative(500000);

    // test BucketSort
    TestSorting.bucketSort(500000, 100);

    // test RadixSort
    TestSorting.radixSort(500000);

    // test RadixSort
    TestSorting.heapSort(500000);

    // test Insertion Sort
    TestSorting.insertionSort(500000);
    
    // test BubbleSort
    TestSorting.bubbleSort(500000);
  }
}
