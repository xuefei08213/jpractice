/**
 * 
 */
package org.jpractice.java8.chap14;

import java.util.stream.IntStream;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-03 07:49:54
 * @Description: TODO
 * @version V1.0
 */
public class LazyListsDemo {

    static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }

    static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

    // IntStream numbers = numbers();
    // int head = head(numbers);
    // IntStream filtered = tail(numbers).filter(n -> n % head != 0);

}
