/**
 * 
 */
package org.jpractice.java8.stream.thread;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-26 06:43:01
 * @Description: TODO
 * @version V1.0
 */
public class BestPriceFinderMain {
    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        // execute("sequential", () ->
        // bestPriceFinder.findPricesSequential("myPhone27S"));
        // execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhone27S"));
        // execute("composed CompletableFuture", () ->
        // bestPriceFinder.findPricesFuture("myPhone27S"));
        bestPriceFinder.printPricesStream("myPhone27S");
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }

}
