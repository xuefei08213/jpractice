/**
 * 
 */
package org.jpractice.java8.stream.optional;

import java.util.Optional;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-13 06:44:32
 * @Description: TODO
 * @version V1.0
 */
public class Person {

    private int age;

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
