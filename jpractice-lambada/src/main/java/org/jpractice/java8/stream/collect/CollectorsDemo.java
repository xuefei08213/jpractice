/**
 * 
 */
package org.jpractice.java8.stream.collect;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jpractice.java8.stream.Dish;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-10 12:56:36
 * @Description: TODO
 * @version V1.0
 */
public class CollectorsDemo {

    static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {

        CollectorsDemo collectorsDemo = new CollectorsDemo();
        collectorsDemo.counting();

    }

    /**
     * 利用counting工厂方法返回的收集器，数一数菜单里面有多少种菜
     */
    public void counting() {
        long count = menu.stream().collect(Collectors.counting());

        // 也可以使用下面的写法
        menu.stream().count();

        System.out.println(String.format("菜谱中一共有%s道菜", count));
    }

    /**
     * 查找流中最大，最小值
     */
    public void maxAndMin() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> optional = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
    }
}
