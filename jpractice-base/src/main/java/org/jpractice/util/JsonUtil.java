/**
 * 
 */
package org.jpractice.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-03 17:31:58
 * @Description: TODO
 * @version V1.0
 */
public class JsonUtil {

    static class User implements Serializable {
        private String name;

        private String phone;

        public User(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

    }

    public static void main(String[] args) {

        List<Map<String, Object>> users = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("a", "aa");
        users.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("b", "bb");
        users.add(map2);

        JSONArray jsonArray = new JSONArray(users);
        System.out.println(jsonArray.toString());

    }
}
