/**
 * 
 */
package org.jpractice.java8.stream.exercise;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-05 19:08:55
 * @Description: TODO
 * @version V1.0
 */
public class Trader {

    private String name;

    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }

}
