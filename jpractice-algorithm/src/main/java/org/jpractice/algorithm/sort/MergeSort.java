/**
 * 
 */
package org.jpractice.algorithm.sort;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-18 13:12:01
 * @Description: TODO
 * @version V1.0
 */
public class MergeSort extends AbstractSort {

    public void sort(Comparable[] a) {

        int length = a.length;

        sort(a, 0, length - 1);

    }

    private void sort(Comparable[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(Comparable[] arr, int low, int mid, int high) {

        System.out.println(low + "-" + mid + "-" + high);
        show(arr);

        Comparable[] aux = new Comparable[arr.length];

        // Find sizes of two subarrays to be merged
        int n1 = mid - low + 1;
        int n2 = high - mid;

        /* Create temp arrays */
        Comparable L[] = new Comparable[n1];
        Comparable R[] = new Comparable[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[low + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = low;
        while (i < n1 && j < n2) {
            if (less(L[i], R[j])) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    // Driver method
    public static void main(String args[]) {
        String arr[] = { "M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        // String arr[] = { "M", "E", "R", "G", "E", "S" };
        System.out.println("Given Array");
        show(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr);

        System.out.println("Sorted array");
        // printArray(arr);
    }
}
