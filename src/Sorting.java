import java.util.Arrays;

public class Sorting {

  public static void InsertionSort(MyArrayList list) {
    int n = list.size();
    for (int i = 2; i <= n; ++i) {
      int key = ((Integer) list.get(i));
      int j = i - 1;

      while (j >= 1 && ((Integer) list.get(j)) > key) {
        list.set(j + 1, list.get(j));
        j = j - 1;
      }
      list.set(j + 1, key);
    }
  }

  public static void BubbleSort(MyArrayList list) {
    int n = list.size();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n - i; j++) {
        if (((Integer) list.get(j)) > ((Integer) list.get(j + 1))) {
          Object temp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, temp);
        }
      }
    }
  }

  // http://www.growingwiththeweb.com/2015/06/bucket-sort.html
  public static void BucketSort(MyArrayList list, int bucketSize) {
    if (list.size() == 0) {
      return;
    }

    // Determine minimum and maximum values
    Integer minValue = (Integer) list.get(1);
    Integer maxValue = (Integer) list.get(1);
    for (int i = 1; i <= list.size(); i++) {
      if ((Integer) list.get(i) < minValue) {
        minValue = (Integer) list.get(i);
      } else if ((Integer) list.get(i) > maxValue) {
        maxValue = (Integer) list.get(i);
      }
    }

    // Initialise buckets
    int bucketCount = (maxValue - minValue) / bucketSize + 1;
    MyArrayList buckets = new MyArrayList(bucketCount);
    for (int i = 0; i < bucketCount; i++) {
      buckets.add(new MyArrayList(100));
    }

    // Distribute input array values into buckets
    for (int i = 1; i <= list.size(); i++) {
      if ((Integer) list.get(i) > 0)
        ((MyArrayList) buckets.get(((Integer) list.get(i) / bucketSize) + 1)).add(list.get(i));
      else
        ((MyArrayList) buckets.get(1)).add(list.get(i));
    }

    // Sort buckets and place back into input array
    int currentIndex = 1;
    for (int i = 1; i <= buckets.size(); i++) {
      MyArrayList bucketArray = (MyArrayList) buckets.get(i);

      InsertionSort(bucketArray);

      for (int j = 1; j <= bucketArray.size(); j++) {
        list.set(currentIndex++, bucketArray.get(j));
      }
    }
  }

  // http://www.geeksforgeeks.org/radix-sort/
  public static void RadixSort(MyArrayList list) {
    // Find the maximum number to know number of digits
    int n = list.size();
    int m = (Integer) list.get(1);

    for (int i = 1; i < n; i++)
      if ((Integer) list.get(i) > m)
        m = (Integer) list.get(i);

    // Do counting sort for every digit. Note that instead
    // of passing digit number, exp is passed. exp is 10^i
    // where i is current digit number
    for (int exp = 1; m / exp > 0; exp *= 10) {
      int output[] = new int[n]; // output array
      int i;
      int count[] = new int[10];
      Arrays.fill(count, 0);

      // Store count of occurrences in count[]
      for (i = 0; i < n; i++)
        count[((Integer) list.get(i + 1) / exp) % 10]++;

      // Change count[i] so that count[i] now contains
      // actual position of this digit in output[]
      for (i = 1; i < 10; i++)
        count[i] += count[i - 1];

      // Build the output array
      for (i = n - 1; i >= 0; i--) {
        output[count[((Integer) list.get(i + 1) / exp) % 10] - 1] = (Integer) list.get(i + 1);
        count[((Integer) list.get(i + 1) / exp) % 10]--;
      }

      // Copy the output array to arr[], so that arr[] now
      // contains sorted numbers according to current digit
      for (i = 0; i < n; i++)
        list.set(i + 1, output[i]);

    }
  }

  public static void HeapSort(MyArrayList list) {
    int n = list.size();

    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i > 0; i--)
      heapify(list, n, i);

    // One by one extract an element from heap
    for (int i = n; i > 0; i--) {
      // Move current root to end
      Object temp = list.get(1);
      list.set(1, list.get(i));
      list.set(i,  temp);

      // call max heapify on the reduced heap
      heapify(list, i, 1);
    }
  }

  // To heapify a subtree rooted with node i which is
  // an index in arr[]. n is size of heap
  static void heapify(MyArrayList list, int n, int i) {
    int largest = i; // Initialize largest as root
    int l = 2 * i + 1; // left = 2*i + 1
    int r = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (l < n && (Integer)list.get(l) > (Integer)list.get(largest))
      largest = l;

    // If right child is larger than largest so far
    if (r < n && (Integer)list.get(r) > (Integer)list.get(largest))
      largest = r;

    // If largest is not root
    if (largest != i) {
      Object swap = list.get(i);
      list.set(i, list.get(largest));
      list.set(largest, swap);

      // Recursively heapify the affected sub-tree
      heapify(list, n, largest);
    }
  }

}
