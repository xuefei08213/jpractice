/**
 * 
 */
package org.jpractice.java8.stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-03 20:56:24
 * @Description: TODO
 * @version V1.0
 */
public class Demo {

    static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {

        System.out.println(new Date().getTime());
        Demo demo = new Demo();

        demo.limit();
        // demo.doOnlyOnce();

        demo.filter();

        demo.distinct();

        demo.skip();

        demo.flatMap();

        demo.square();

        demo.numberPair();

        demo.findAny();
    }

    public void limit() {
        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName)
                .limit(3).collect(toList());
        System.out.println(threeHighCaloricDishNames);
    }

    /**
     * 流只能遍历一次
     */
    public void doOnlyOnce() {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);

        // 会出现stream has already been operated upon or closed 异常
        s.forEach(System.out::println);
    }

    private void filter() {
        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVagetarian).collect(toList());
        vegetarianMenu.stream().forEach(d -> {
            System.out.println(d.getName());
        });
    }

    private void distinct() {
        List<Integer> nums = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        nums.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    }

    /**
     * 返回一个扔掉了前n个元素的流。如果流中元素不足n个，则返回一个空流
     */
    private void skip() {
        List<Dish> dishs = menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(toList());
        dishs.stream().forEach(x -> {
            System.out.println(x.getName());
        });
    }

    /**
     * 利用映射map
     */
    private void getNameLengthOfMenu() {
        List<Integer> integers = menu.stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println(integers.toString());
    }

    /**
     * 对于一张单词表，如何返回一张列表，列出里面各不相同的字符
     */

    public void flatMap() {
        String[] words = new String[] { "hello", "world" };
        List<String> distinctWords = Arrays.asList(words).stream().map(word -> word.split("")).flatMap(Arrays::stream)
                .distinct().collect(toList());
        System.out.println(distinctWords);
    }

    /**
     * 给定一个数字列表，返回一个由每个数的平方构成的表
     */

    public void square() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> squares = integers.stream().map(i -> i * i).collect(toList());
        System.out.println(String.format("square:%s", squares));
    }

    /**
     * 给定两个数字列表，如何返回所有的数对
     */
    public void numberPair() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        
        List<int[]> list = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
                .collect(toList());

        System.out.println(list);
    }

    /**
     */
    public void numberPairDiv() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        
        List<int[]> list = numbers1.stream()
                .flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
                .collect(toList());
    }

    /**
     * 菜单里面是否有素食可选择
     */
    public void anyMatch() {
        if (menu.stream().anyMatch(Dish::isVagetarian)) {
            System.out.println("The menu is (somwhat) vagetarian friendly!!");
        }
    }

    /**
     * 所有的菜的热量都低于1000卡路里
     */
    public void allMatch() {
        System.out.println(menu.stream().allMatch(d -> d.getCalories() < 1000));
    }

    /**
     * 没有菜的热量大于等于1000
     */
    public void noneMatch() {
        System.out.println(menu.stream().noneMatch(d -> d.getCalories() >= 1000));
    }

    public void findAny() {
        menu.stream().filter(Dish::isVagetarian).findAny().ifPresent(d -> System.out.println(d.getName()));
    }

    /**
     * 归约求和
     */
    public void reduceSum() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = integers.stream().reduce(0, (a, b) -> a + b);

        // 这里返回Optional，是因为在流没有任何元素的情况下，reduce将无法返回其和，因为它没有初始值
        Optional<Integer> sum2 = integers.stream().reduce((a, b) -> a + b);
    }

    /**
     * 归约最大值
     */
    public void reduceMax() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().reduce(Integer::max);
    }

    /**
     * 归约最小值
     */
    public void reduceMin() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().reduce(Integer::min);
    }

    /**
     * map-reduce模式 使用map和reduce方法统计数据流中共有多少个菜
     */
    public void countOfMenu() {
        menu.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
    }

}
