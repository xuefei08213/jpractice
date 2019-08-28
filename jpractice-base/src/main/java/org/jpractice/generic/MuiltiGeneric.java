/**
 * 
 */
package org.jpractice.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-08 11:06:44
 * @Description: TODO
 * @version V1.0
 */
public class MuiltiGeneric {
    
    public static void main(String[] args) {
        List<Map<String, String>> maps = new ArrayList<>();

        Map<String, String> a = new HashMap<>();
        Map<String, String> b = new HashMap<>();
        Map<String, String> c = new HashMap<>();

        maps.add(a);
        maps.add(b);
        maps.add(c);
    }

    class User {
        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

}
