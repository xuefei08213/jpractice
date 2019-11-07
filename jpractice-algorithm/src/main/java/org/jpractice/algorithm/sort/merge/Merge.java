/**
 * 
 */
package org.jpractice.algorithm.sort.merge;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-10-31 08:29:43
 * @Description: TODO
 * @version V1.0
 */
public class Merge<Key extends Comparable<Key>> {

    public void sort(Key[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Key[] a, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(Key[] a, int lo, int mid, int hi) {

        int leftSize = mid - lo + 1;
        int rightSize = hi - mid;

        Comparable<Key>[] left = new Comparable[leftSize];
        Comparable<Key>[] right = new Comparable[rightSize];

        /* Copy data to temp arrays */
        for (int i = 0; i < leftSize; ++i)
            left[i] = a[lo + i];
        for (int j = 0; j < rightSize; ++j)
            right[j] = a[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = lo;
        while (i < leftSize && j < rightSize) {
            if (less(left[i], right[j])) {
                a[k] = (Key) left[i];
                i++;
            } else {
                a[k] = (Key) right[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < leftSize) {
            a[k] = (Key) left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < rightSize) {
            a[k] = (Key) right[j];
            j++;
            k++;
        }
    }

    public void sortWittAux(Key[] a) {

        Comparable[] aux = new Comparable[a.length];
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }

    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        String arr[] = { "M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println("Given Array");

        Merge<String> ob = new Merge<>();
        ob.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Sorted array");
    }

}
