/**
 * 
 */
package org.jpractice.generic;

import java.time.LocalDate;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-12 00:23:07
 * @Description: TODO
 * @version V1.0
 */
public class PairTest {

    public static void main(String[] args) {


        // Pair<String>[] pairs = new Pair<String>[10];

        String[] words = { "Mary", "had", "a", "little", "lamb" };
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());

        // int[] nums = {1,2,4};
        // ArrayAlg.minmax(nums); // 因为int没有实现Comparable接口，yin

        Integer[] integers = { Integer.parseInt("1") };
        ArrayAlg.minmax(integers);

        LocalDate date = LocalDate.now();
        LocalDate date2 = LocalDate.of(2019, 6, 21);
        LocalDate date3 = LocalDate.of(2019, 6, 20);

        LocalDate[] localDates = { date, date2, date3 };
        ArrayAlg.minmax(localDates);
    }

}

class ArrayAlg {
    public static <T extends Comparable<? super T>> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0)
            return null;

        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0)
                min = a[i];
            if (max.compareTo(a[i]) < 0)
                max = a[i];
        }

        return new Pair<>(min, max);
    }
}
