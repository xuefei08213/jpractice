/**
 * 
 */
package org.jpractice.java8.stream.parallel;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-11 20:33:39
 * @Description: TODO
 * @version V1.0
 */
public class ParallelStreams {

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (Long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public long measureSumPerf(Function<Long, Long> adder, long n) {

        long faster = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < faster)
                faster = duration;
        }

        return faster;

    }

    /**
     * 求和方法的并行版本比顺序版本要慢很多 存在以下两个问题： iterate生成的是装箱的对象，必须拆装成数字才能求和
     * 很难把iterate分成多个独立块来并行执行，因为每次应用这个函数都要依赖前一次应用的结果
     * 
     * @param args
     */
    public static void main(String[] args) {
        ParallelStreams parallelStreams = new ParallelStreams();
        System.out.println(String.format("sequential Sum done in: %s msecs",
                parallelStreams.measureSumPerf(ParallelStreams::sequentialSum, 1_000_000)));

        System.out.println(String.format("iterative Sum done in: %s msecs",
                parallelStreams.measureSumPerf(ParallelStreams::iterativeSum, 1_000_000)));

        System.out.println(String.format("parallel Sum done in: %s msecs",
                parallelStreams.measureSumPerf(ParallelStreams::parallelSum, 1_000_000)));

    }

}
