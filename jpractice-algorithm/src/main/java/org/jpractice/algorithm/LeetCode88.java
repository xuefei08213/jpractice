/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-19 22:36:29
 * @Description: TODO
 * @version V1.0
 */
public class LeetCode88 {

    public void merge2(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        while (j >= 0)
            A[k--] = B[j--];

        printArray(A);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < m) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        for (int h = 0; h < temp.length; h++) {
            nums1[h] = temp[h];
        }

        printArray(nums1);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
