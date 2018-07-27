/**
 * 
 */
package org.jpractice.java8.stream.thread;

import static org.jpractice.java8.stream.thread.Util.delay;
import static org.jpractice.java8.stream.thread.Util.format;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-26 06:24:34
 * @Description: TODO
 * @version V1.0
 */
public class AsyncShop {

    private final String name;

    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        this.random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getPrice(String product) {

        /**
            CompletableFuture<Double> completableFuture = new CompletableFuture<>();
            new Thread(() -> {
                try {
                    double price = calculatePrice(product);
                    completableFuture.complete(price);
                } catch (Exception e) {
                    completableFuture.completeExceptionally(e);
                }
                
            }).start();
            return completableFuture;
         */
        
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));

    }

    @SuppressWarnings("unused")
    private double calculatePrice(String product) {
        delay();
        // if (true)
        // throw new RuntimeException("product not available");
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

}
