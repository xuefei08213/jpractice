/**
 * 
 */
package org.jpractice.collection.hashmap;

import java.util.HashMap;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-11-02 07:02:43
 * @Description: TODO
 * @version V1.0
 */
public class MapTestClient {

    public static void main(String[] args) {

        HashMap<TestElement, String> map = new HashMap<>();
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
        map.put(new TestElement("xuefei"), "11");
    }

}
