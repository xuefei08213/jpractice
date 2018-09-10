/**
 * 
 */
package org.jpractice.springboot.h2.model;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-10 18:47:25
 * @Description: TODO
 * @version V1.0
 */
public class User {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
