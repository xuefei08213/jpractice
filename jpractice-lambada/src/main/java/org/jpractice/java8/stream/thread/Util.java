/**
 * 
 */
package org.jpractice.java8.stream.thread;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-25 07:19:33
 * @Description: TODO
 * @version V1.0
 */
public class Util {

    private static final Random RANDOM = new Random();

    private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay() {
        // int delay = 1000;
        int delay = 500 + RANDOM.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static double format(double number) {
        synchronized (formatter) {
            return new Double(formatter.format(number));
        }
    }

    public static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {
        return CompletableFuture
                .supplyAsync(() -> futures.stream().map(future -> future.join()).collect(Collectors.toList()));
    }

}
