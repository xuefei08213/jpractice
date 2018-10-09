/**
 * 
 */
package org.jpractice.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-06 06:44:38
 * @Description: TODO
 * @version V1.0
 */
public class ArrayListTest {

    public static void main(String[] args) {

        Object[] elementData = {};

        Object[] newElementData = Arrays.copyOf(elementData, 10);
        System.out.println(newElementData.length);

        List<String> list = new ArrayList<>(100);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
    }

}
