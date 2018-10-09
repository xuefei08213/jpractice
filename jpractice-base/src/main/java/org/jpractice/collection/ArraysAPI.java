/**
 * 
 */
package org.jpractice.collection;

import java.util.Arrays;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-09 06:29:03
 * @Description: TODO
 * @version V1.0
 */
public class ArraysAPI {

    public static void main(String[] args) {
        int[] original = { 1, 2, 3, 4 };
        int[] newArray = Arrays.copyOf(original, 2);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }

        System.out.println("=========");

        // 左开右闭
        newArray = Arrays.copyOfRange(original, 1, 3);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }

    }

    public void SystemArrayCopy() {
    }

}
