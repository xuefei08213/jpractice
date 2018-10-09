/**
 * 
 */
package org.jpractice.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-02 07:56:55
 * @Description: TODO
 * @version V1.0
 */
public class MainClient {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

    }
}
