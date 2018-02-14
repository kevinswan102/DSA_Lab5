
public class TestSorting {

  public static MyArrayList loadArrayList(int size) {
    MyArrayList list = new MyArrayList(size);

    for (int i = 1; i <= size; i++) {
      list.add((int) (Math.random() * size));
    }

    return list;
  }

  public static void mergeSort(int size) {

    MyArrayList unsortedList = loadArrayList(size);

    System.out.println("-------------------------------------------------");
    System.out.println("Merge Sort - List Size = " + size);

    /*
     * System.out.println("Printing original list");
     * Object[] newlist = unsortedList.toArray(); for (int i = 0; i <
     * newlist.length; i++) { System.out.print(newlist[i] + ","); }
     * System.out.print("\n");
     */

    if (unsortedList.size() > 0) {
      MergeSort sortObj = new MergeSort();

      long startTime = System.currentTimeMillis();
      sortObj.sort(unsortedList, 0, unsortedList.size() - 1);
      long estimatedTime = System.currentTimeMillis() - startTime;

      System.out.println("Estimated time to sort- " + estimatedTime);

      /*
       * System.out.println("Printing list after sort - estimated time - " +
       * estimatedTime);
       * newlist = unsortedList.toArray(); for (int i = 0; i < newlist.length; i++) {
       * System.out.print(newlist[i] + ","); } System.out.print("\n");
       */
      
      System.out.println("-------------------------------------------------");
    }
  }

  public static void quickSort(int size) {

    MyArrayList unsortedList = loadArrayList(size);

    System.out.println("-------------------------------------------------");
    System.out.println("Quick Sort - List Size = " + size);
    

    /*
     * System.out.println("Printing original list");
     * Object[] newlist = unsortedList.toArray(); for (int i = 0; i <
     * newlist.length; i++) { System.out.print(newlist[i] + ","); }
     * System.out.print("\n");
     */

    if (unsortedList.size() > 0) {
      QuickSort sortObj = new QuickSort();

      long startTime = System.currentTimeMillis();
      sortObj.RecursiveSort(unsortedList, 0, unsortedList.size() - 1);
      long estimatedTime = System.currentTimeMillis() - startTime;

      System.out.println("Estimated time to sort- " + estimatedTime);

      /*
       * System.out.println("Printing list after sort - estimated time - " +
       * estimatedTime);
       * newlist = unsortedList.toArray(); for (int i = 0; i < newlist.length; i++) {
       * System.out.print(newlist[i] + ","); } System.out.print("\n");
       */
      System.out.println("-------------------------------------------------");
    }
  }

  public static void quickSortIterative(int size) {

    MyArrayList unsortedList = loadArrayList(size);

    System.out.println("-------------------------------------------------");
    System.out.println("Iterative Quick Sort - List Size = " + size);

    /*
     * System.out.println("Printing original list");
     * Object[] newlist = unsortedList.toArray(); for (int i = 0; i <
     * newlist.length; i++) { System.out.print(newlist[i] + ","); }
     * System.out.print("\n");
     */

    if (unsortedList.size() > 0) {
      QuickSort sortObj = new QuickSort();

      long startTime = System.currentTimeMillis();
      sortObj.IterativeSort(unsortedList);
      long estimatedTime = System.currentTimeMillis() - startTime;

      System.out.println("Estimated time to sort- " + estimatedTime);

      /*
       * System.out.println("Printing list after sort - estimated time - " +
       * estimatedTime);
       * newlist = unsortedList.toArray(); for (int i = 0; i < newlist.length; i++) {
       * System.out.print(newlist[i] + ","); } System.out.print("\n");
       */
      System.out.println("-------------------------------------------------");
    }
  }

  public static void insertionSort(int size) {

    MyArrayList unsortedList = loadArrayList(size);

    System.out.println("-------------------------------------------------");
    System.out.println("Insertion Sort - List Size = " + size);

    /*
     * System.out.println("Printing original list");
     * Object[] newlist = unsortedList.toArray(); for (int i = 0; i <
     * newlist.length; i++) { System.out.print(newlist[i] + ","); }
     * System.out.print("\n");
     */

    if (unsortedList.size() > 0) {

      long startTime = System.currentTimeMillis();
      Sorting.InsertionSort(unsortedList);
      long estimatedTime = System.currentTimeMillis() - startTime;

      System.out.println("Estimated time to sort- " + estimatedTime);

      /*
       * System.out.println("Printing list after sort - estimated time - " +
       * estimatedTime);
       * newlist = unsortedList.toArray(); for (int i = 0; i < newlist.length; i++) {
       * System.out.print(newlist[i] + ","); } System.out.print("\n");
       */
      System.out.println("-------------------------------------------------");
    }
  }

  public static void bubbleSort(int size) {

    MyArrayList unsortedList = loadArrayList(size);

    System.out.println("-------------------------------------------------");
    System.out.println("Bubble Sort - List Size = " + size);

    /*
     * System.out.println("Printing original list");
     * Object[] newlist = unsortedList.toArray(); for (int i = 0; i <
     * newlist.length; i++) { System.out.print(newlist[i] + ","); }
     * System.out.print("\n");
     */
    if (unsortedList.size() > 0) {

      long startTime = System.currentTimeMillis();
      Sorting.BubbleSort(unsortedList);
      long estimatedTime = System.currentTimeMillis() - startTime;

      System.out.println("Estimated time to sort- " + estimatedTime);

      /*
       * System.out.println("Printing list after sort - estimated time - " +
       * estimatedTime);
       * newlist = unsortedList.toArray(); for (int i = 0; i < newlist.length; i++) {
       * System.out.print(newlist[i] + ","); } System.out.print("\n");
       */
      System.out.println("-------------------------------------------------");
    }
  }

  public static void bucketSort(int size, int buckets) {

    MyArrayList unsortedList = loadArrayList(size);

    System.out.println("-------------------------------------------------");
    System.out.println("Bucket Sort - List Size = " + size);

    /*
     * System.out.println("Printing original list");
     * Object[] newlist = unsortedList.toArray(); for (int i = 0; i <
     * newlist.length; i++) { System.out.print(newlist[i] + ","); }
     * System.out.print("\n");
     */

    if (unsortedList.size() > 0) {

      long startTime = System.currentTimeMillis();
      Sorting.BucketSort(unsortedList, buckets);
      long estimatedTime = System.currentTimeMillis() - startTime;

      System.out.println("Estimated time to sort- " + estimatedTime);

      /*
       * System.out.println("Printing list after sort - estimated time - " +
       * estimatedTime);
       * newlist = unsortedList.toArray(); for (int i = 0; i < newlist.length; i++) {
       * System.out.print(newlist[i] + ","); } System.out.print("\n");
       */
      System.out.println("-------------------------------------------------");
    }
  }

  public static void radixSort(int size) {

    MyArrayList unsortedList = loadArrayList(size);

    System.out.println("-------------------------------------------------");
    System.out.println("Radix Sort - List Size = " + size);

    /*
     * System.out.println("Printing original list");
     * Object[] newlist = unsortedList.toArray(); for (int i = 0; i <
     * newlist.length; i++) { System.out.print(newlist[i] + ","); }
     * System.out.print("\n");
     */

    if (unsortedList.size() > 0) {

      long startTime = System.currentTimeMillis();
      Sorting.RadixSort(unsortedList);
      long estimatedTime = System.currentTimeMillis() - startTime;

      System.out.println("Estimated time to sort- " + estimatedTime);

      /*
       * System.out.println("Printing list after sort - estimated time - " +
       * estimatedTime);
       * newlist = unsortedList.toArray(); for (int i = 0; i < newlist.length; i++) {
       * System.out.print(newlist[i] + ","); } System.out.print("\n");
       */
      System.out.println("-------------------------------------------------");
    }
  }

  public static void heapSort(int size) {

    MyArrayList unsortedList = loadArrayList(size);

    System.out.println("-------------------------------------------------");
    System.out.println("Heap Sort - List Size = " + size);

    /*
     * System.out.println("Printing original list");

     * Object[] newlist = unsortedList.toArray(); for (int i = 0; i <
     * newlist.length; i++) { System.out.print(newlist[i] + ","); }
     * System.out.print("\n");
     */
    if (unsortedList.size() > 0) {

      long startTime = System.currentTimeMillis();
      Sorting.HeapSort(unsortedList);
      long estimatedTime = System.currentTimeMillis() - startTime;

      System.out.println("Estimated time to sort- " + estimatedTime);

      /*
       * System.out.println("Printing list after sort - estimated time - " +
       * estimatedTime);
       * newlist = unsortedList.toArray(); for (int i = 0; i < newlist.length; i++) {
       * System.out.print(newlist[i] + ","); } System.out.print("\n");
       */
      System.out.println("-------------------------------------------------");
    }
  }

}
