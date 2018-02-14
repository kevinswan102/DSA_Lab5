/**
 * @author chakkac5 Interface provides the methods to implement
 */
@SuppressWarnings("hiding")
public interface MyList<Comparable> {

  public boolean add(int index, Comparable o);

  public boolean add(Comparable o);

  public boolean clear();

  public boolean contains(Comparable o);

  public Comparable get(int index);

  public int indexOf(Comparable o);

  public boolean isEmpty();

  public Comparable remove(int index);

  public Comparable remove(Comparable o);

  public boolean set(int index, Comparable element);

  public int size();

  public MyList<Comparable> subList(int fromIndex, int toIndex);

  public Comparable[] toArray();

  public boolean swap(int position1, int position2);

  public boolean shift(int positions);

}