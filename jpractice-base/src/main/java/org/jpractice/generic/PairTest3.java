/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-16 10:40:58
 * @Description: TODO
 * @version V1.0
 */
public class PairTest3 {

    public static void main(String[] args) {
        Manager ceo = new Manager("ceo", 10000);
        Manager cfo = new Manager("cfo", 80000);
        Pair<Manager> buddies = new Pair<>(ceo, cfo);

        printBuddies(buddies);

        Manager[] managers = { ceo, cfo };
        Pair<Manager> result = new Pair<>();

        minmaxBouns(managers, result);
        System.out.println(" first: " + result.getFirst().getName() + " second " + result.getSecond().getName());

        maxminBounds(managers, result);
        System.out.println(" first: " + result.getFirst().getName() + " second " + result.getSecond().getName());

    }

    public static void printBuddies(Pair<? extends Employee> pair) {

        Employee first = pair.getFirst();
        Employee second = pair.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " is buddies");
    }

    public static void minmaxBouns(Manager[] managers, Pair<? super Manager> result) {

        if (managers.length == 0)
            return;
        Manager min = managers[0];
        Manager max = managers[0];

        for (int i = 1; i < managers.length; i++) {
            if (managers[i].getBounds() < min.getBounds()) {
                min = managers[i];
            }
            if (managers[i].getBounds() > max.getBounds()) {
                max = managers[i];
            }
        }

        result.setFirst(min);
        result.setSecond(max);

        Manager manager = (Manager) result.getFirst();
        System.out.println(manager.getName());

    }

    public static void maxminBounds(Manager[] managers, Pair<? super Manager> result) {
        minmaxBouns(managers, result);
        PairAlg.swapHelper(result);
    }

}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p.getSecond() == null || p.getFirst() == null;
    }

    public static void swap(Pair<?> p) {
        swap(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);

    }
}
