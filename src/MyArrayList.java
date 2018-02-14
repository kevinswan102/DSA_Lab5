
/**
 * @author chakkac5 implementing the interface to a generic array list
 */

@SuppressWarnings("rawtypes")
public class MyArrayList implements MyList {

  private Object[] list;

  private int size;
  private int maxSize;

  public MyArrayList(int maxItems) {
    maxSize = maxItems;
    list = new Object[maxSize];
    size = 0;
  }

  @Override
  public boolean add(int index, Object o) {
    if (index < 1 || index > size) {
      throw new ArithmeticException("Index out of bounds");
    }

    if (list.length == size) {
      Object[] list2 = new Object[size * 2];
      copyArray(list, 0, list2, 0, list.length);
      list = list2;
    }

    Object tempValue = (Object) list[index - 1];

    list[index - 1] = o;
    list[size] = tempValue;

    size++;

    if (list[index - 1] == o)
      return true;
    else
      return false;
  }

  @Override
  public boolean add(Object o) {

    if (list.length == size) {
      Object[] list2 = new Object[size * 2];

      copyArray(list, 0, list2, 0, list.length);

      list = list2;
    }
    list[size] = o;
    size++;

    return true;
  }

  @Override
  public boolean clear() {
    list = new Object[maxSize];
    size = 0;

    return true;
  }

  @Override
  public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
      if (list[i] == o) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Object get(int index) {

    if (index < 1 || index > size) {
      throw new ArithmeticException("Index out of bounds");
    }

    return (Object) list[index - 1];
  }

  @Override
  public int indexOf(Object o) {

    for (int i = 0; i < size; i++) {
      if (list[i] == o) {
        return i;
      }
    }

    return -1;
  }

  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else
      return false;
  }

  @Override
  public Object remove(int index) {
    if (index < 1 || index > size) {
      throw new ArithmeticException("Index out of bounds");
    }

    Object tempValue = (Object) list[index - 1];
    list[index - 1] = list[size - 1];
    list[size - 1] = null;
    size--;
    return tempValue;
  }

  @Override
  public Object remove(Object o) {

    for (int i = 0; i < size; i++) {
      if (list[i].equals(o)) {
        Object tempValue = (Object) list[i];
        list[i] = list[size - 1];
        list[size - 1] = null;
        size--;
        return tempValue;
      }
    }
    return null;
  }

  @Override
  public boolean set(int index, Object element) {
    if (index < 1 || index > size) {
      throw new ArithmeticException("Index out of bounds");
    }
    
    list[index - 1] = element;
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public MyList subList(int fromIndex, int toIndex) {

    if (fromIndex < 0 || fromIndex > size || toIndex < 0 || toIndex > size) {
      throw new ArithmeticException("Index out of bounds");
    }

    MyArrayList subList = new MyArrayList(Math.abs(toIndex - fromIndex));
    for (int i = fromIndex; i < toIndex; i++) {
      subList.add(list[i]);
    }

    return subList;
  }

  @Override
  public Object[] toArray() {
    Object[] arrayOfList = new Object[size];

    for (int i = 0; i < size; i++) {
      arrayOfList[i] = (Object) list[i];
    }

    return arrayOfList;
  }

  @Override
  public boolean swap(int position1, int position2) {
    if (position1 < 1 || position1 >= size || position2 < 1 || position2 >= size) {
      throw new ArithmeticException("Index out of bounds");
    }

    Object temp = list[position1 - 1];
    list[position1 - 1] = list[position2 - 1];
    list[position2 - 1] = temp;

    return true;
  }

  @Override
  public boolean shift(int positions) {
    if (Math.abs(positions) > size)
      throw new ArithmeticException("Index out of bounds");

    if (positions >= 0) {

      MyArrayList newList = (MyArrayList) subList(positions + 1, size);

      for (int i = 0; i < positions + 1; i++) {
        newList.add((Object) list[i]);
      }

      list = newList.list;
    } else if (positions < 0) {
      MyArrayList firstList = (MyArrayList) subList(size + positions, size);
      MyArrayList secondList = (MyArrayList) subList(0, size + positions);

      MyArrayList result = new MyArrayList(size);
      copyArray(firstList.list, 0, result.list, 0, firstList.size);
      copyArray(secondList.list, 0, result.list, firstList.size, secondList.size);

      list = result.list;
    }

    return true;
  }

  private void copyArray(Object[] sourceList, int startPosition, Object[] destList, int destPosition,
      int noOfItemsToCopy) {
    for (int i = 0; i < noOfItemsToCopy; i++) {
      destList[destPosition + i] = sourceList[startPosition + i];
      
    }
  }
}
