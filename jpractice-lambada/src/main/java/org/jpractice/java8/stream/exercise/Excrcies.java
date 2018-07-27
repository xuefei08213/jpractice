/**
 * 
 */
package org.jpractice.java8.stream.exercise;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-05 19:15:56
 * @Description: TODO
 * @version V1.0
 */
public class Excrcies {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

        exec1(transactions);
        exec2(transactions);
        exec3(transactions);
        exec4(transactions);
        exec5(transactions);
        exec6(transactions);
    }

    // 找出2011年发生的所有的交易，并按照交易额排序（从低到高）
    private static void exec1(List<Transaction> transactions) {
        List<Transaction> list = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted((x, y) -> x.getValue() - y.getValue())
                .collect(toList());
        System.out.println("找出2011年发生的所有的交易，并按照交易额排序（从低到高）");
        list.forEach(t -> {
            System.out.println(t.getYear() + ">>>>" + t.getValue());
        });
    }

    // 交易员都在哪些不同的城市工作过
    private static void exec2(List<Transaction> transactions) {
        List<String> citys = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList());
        System.out.println("交易员都在哪些不同的城市工作过");
        citys.forEach(c -> {
            System.out.println(c);
        });
    }

    // 查找所有来自剑桥的交易员，并按照名字排序
    private static void exec3(List<Transaction> transactions) {
        List<Trader> traders = transactions.stream().map(t -> t.getTrader()).distinct()
                .filter(trader -> "Cambridge".equals(trader.getCity())).sorted(Comparator.comparing(Trader::getName))
                .collect(toList());

        System.out.println("查找所有来自剑桥的交易员，并按照名字排序");
        traders.forEach(c -> {
            System.out.println(c.getName());
        });
    }

    // 返回所有交易员的姓名字符串，按字母顺序排序
    private static void exec4(List<Transaction> transactions) {
        String traders = transactions.stream().map(t -> t.getTrader().getName()).distinct()
                .sorted().reduce("", (n1, n2) -> n1 + n2);

        // collect(joining)

        System.out.println("返回所有交易员的姓名字符串，按字母顺序排序");
        System.out.println(traders);
    }

    // 有没有交易员在米兰工作
    private static void exec5(List<Transaction> transactions) {

        boolean flag = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        if (flag) {
            System.out.println("有交易员在米兰工作");
        } else {
            System.out.println("没有交易员在米兰工作");
        }
    }

    // 打印出所有在剑桥的交易员的所有交易额
    private static void exec6(List<Transaction> transactions) {

        transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue)
                .forEach(System.out::println);
    }

    // 找出所有的交易中最高的交易额
    private static void exec7(List<Transaction> transactions) {

        transactions.stream().map(Transaction::getValue).reduce(Integer::max);
    }

    // 找出交易额最小的交易
    private static void exec8(List<Transaction> transactions) {

        transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
    }

}
