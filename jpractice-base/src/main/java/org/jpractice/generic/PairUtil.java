/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-15 08:17:15
 * @Description: TODO
 * @version V1.0
 */
public class PairUtil {

    public static void printBuddies(Pair<? extends Employee> pair) {

        Employee first = pair.getFirst();
        Employee second = pair.getSecond();

        System.out.println(first.getName() + " and " + second.getName() + "are buddies");

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

    }

    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

}
