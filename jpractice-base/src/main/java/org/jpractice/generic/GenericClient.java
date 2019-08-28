/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-11 20:51:25
 * @Description: TODO
 * @version V1.0
 */
public class GenericClient {

    public static void main(String[] args) {
        // ArrayList arrayList = new ArrayList();
        // arrayList.add("generic");
        // arrayList.add(new Date());
        //
        // String generic = (String) arrayList.get(0);
        // System.out.println(generic);
        // String date = (String) arrayList.get(1);
        // System.out.println(date);
        wildcard();
    }

    public static void wildcard() {
        Employee first = new Employee("xuefei");
        Employee second = new Employee("chengf");
        Pair<Employee> pair = new Pair<Employee>(first, second);
        PairUtil.printBuddies(pair);

        Manager firstManager = new Manager("wangmg", 1000);
        Manager secondManager = new Manager("wumeng", 2000);
        Pair<Manager> pair2 = new Pair<Manager>(firstManager, secondManager);
        PairUtil.printBuddies(pair2);

        Pair<? extends Employee> wildcardPair = pair2;
        wildcardPair.getFirst();

    }

}
