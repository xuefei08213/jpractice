/**
 * 
 */
package org.jpractice.java8.stream.optional;

import java.util.Optional;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-13 07:21:44
 * @Description: TODO
 * @version V1.0
 */
public class OptionalTest {

    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();
        System.out.println(optionalTest.map());
    }

    public String map() {
        Insurance insurance = new Insurance();
        Optional<Insurance> optional = Optional.ofNullable(insurance);
        return optional.map(Insurance::getName).orElse("没有设置名称");
    }


    public String flatMap() {
        Optional<Person> person = Optional.of(new Person());

        // flatMap方法接受一个函数作为参数，这个函数返回的值是一个流。这个方法会应用到流中的每一个元素，最终形成一个新的流
        // 但是flatMap会用流的内容替换每个新生成的流。换句话说，由方法生成的各个流会被合并或者扁平化为一个单一流
        // 对于optioal也是类似的

        String name = person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName)
                .orElse("没有设置名称");
        return name;
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        // 不同保险公司提供的查询服务
        // 对比所有数据

        Insurance cheapestCompany = new Insurance();
        return cheapestCompany;
    }


    public Optional<Insurance> nullSafefindCheapestInsurance(Optional<Person> person, Optional<Car> car) {

        // 以不解包的方式组合两个Optional对象
        person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));

        // 下面的这种写法跟null检查太相似
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    // 对Option对象进行过滤
    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge).flatMap(Person::getCar).flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("Unkown");
    }


}
