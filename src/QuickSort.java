
public class QuickSort {

  int partition(MyArrayList list, int low, int high)
   {
       int pivot = (Integer)list.get(high + 1);
       int i = (low-1); // index of smaller element
       for (int j=low; j<high; j++)
       {
           // If current element is smaller than or
           // equal to pivot
           if ((Integer)list.get(j+1) <= pivot)
           {
               i++;
               // swap
               Object temp = list.get(i + 1);
               list.set(i + 1, list.get(j + 1));
               list.set(j + 1,temp);
           }
       }

       // swap i+1 and high (or pivot)
       Object temp = list.get(i + 2);
       list.set(i + 2, list.get(high + 1));
       list.set(high + 1,temp);

       return i+1;
   }


   void RecursiveSort(MyArrayList list, int low, int high)
   {
       if (low < high)
       {
           /* pi is partitioning index, list[pi + 1] is 
             now at right place */
           int pi = partition(list, low, high);

           // Recursively sort elements before
           // partition and after partition
           RecursiveSort(list, low, pi-1);
           RecursiveSort(list, pi+1, high);
       }
   }
   
   //http://kosbie.net/cmu/summer-08/15-100/handouts/IterativeQuickSort.java
   public void IterativeSort(MyArrayList list) {
     int[] skip = new int[list.size() + 1];
     int[] range = new int[list.size()];
     range[0] = list.size() - 1;
     int i, j, sortedCount = 0;
     while (sortedCount < list.size()) {
       for (i = 0; i < list.size(); i++)
         if (range[i] >= i) {
           j = range[i];
           for (; i <= j; i++) {
             int p = partition(list, i, j);
             sortedCount++;
             if (p > i)
               range[i] = p - 1;
             range[p] = -1; // sorted
             if (p < j)
               range[p + 1] = j;
             skip[i = p] = 1;
           }
         } else {
           // skip[i] += skip[i + skip[i]];
           while ((j = skip[i + skip[i]]) > 0)
             skip[i] += j;
           i += skip[i] - 1;
         }
     }
   }

}