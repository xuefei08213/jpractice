/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-12 07:39:56
 * @Description: TODO
 * @version V1.0
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        // int total = 0;
        // int size = digits.length - 1;
        //
        // for (int i = size; i >= 0; i--) {
        // int num = digits[size - i];
        // total += num * Math.pow(10, i);
        // }
        //
        // total = total + 1;
        // String sTotal = String.valueOf(total);
        // String[] s = sTotal.split("");
        // int[] integers = new int[s.length];
        // for (int j = 0; j < s.length; j++) {
        // integers[j] = Integer.valueOf(s[j]);
        // }
        //
        // return integers;
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }
        
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
    }
}
