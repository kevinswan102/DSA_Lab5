
public class MergeSort {

  void sort(MyArrayList list, int left, int right) {

    if (left < right) {
      int midPoint = (left + right) / 2;

      sort(list, left, midPoint);
      sort(list, midPoint + 1, right);

      // merge the sorted lists
      merge(list, left, midPoint, right);
    }
  }

  void merge(MyArrayList list, int left, int midPoint, int right) {

    int leftSize = midPoint - left + 1;
    int rightSize = right - midPoint;

    // Create list
    MyArrayList leftList = new MyArrayList(leftSize);
    MyArrayList rightList = new MyArrayList(rightSize);

    // Copy data
    for (int i = 0; i < leftSize; i++) 
      leftList.add(list.get(left + i + 1));
    
    for (int j = 0; j < rightSize; j++)
      rightList.add(list.get(midPoint + 1 + j + 1));

    int i = 0, j = 0;

    int k = left;

    while (i < leftSize && j < rightSize) {
      int compareResult = ((Integer) leftList.get(i + 1)).compareTo((Integer) rightList.get(j + 1));

      if (compareResult < 0) {
        list.set(k + 1, leftList.get(i+1));
        i++;
      } else {
        list.set(k + 1, rightList.get(j+1));
        j++;
      }
      k++;
    }

    while (i < leftSize) {
      list.set(k + 1, leftList.get(i + 1));
      i++;
      k++;
    }

    while (j < rightSize) {
      list.set(k + 1, rightList.get(j + 1));
      j++;
      k++;
    }
  }

}
