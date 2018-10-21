/**
 * 
 */
package org.jpractice.collection;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-02 07:56:55
 * @Description: TODO
 * @version V1.0
 */
public class MainClient {

    public static void main(String[] args) {

        // System.out.println("aa".substring(0));
        //
        // System.out.println(Double.valueOf("1.22"));

        String s = "# 2 117093590999498754 安阳电厂安#10主变 2 230 0 20  450.000    0.000  450.000 5 1 3   -0.026  220.000 0 0 0    0.000    0.000   20.000    0.358   25.434    0.000    0.000    0.000    0.000 安阳电厂.230.nd24  '' 安阳电厂.20.nd30 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 3 0 1 0 0 '' '' '' '' '' '' 3 -2    0.000    0.000 39 -1 69 24 -2 30 8 -1 8    0.001    0.048    0.000    0.000    0.001    0.048    1.045    0.000    1.000  230.000    0.000   20.000\n"
                + "";

        String[] sArray = s.split("\\s+");
        for (int i = 0; i < sArray.length; i++) {
            System.out.println(sArray[i]);
        }

        // List<String> list = new ArrayList<>();
        // list.add("1");
        // list.add("1");
        // list.add("1");
        // list.add("1");
        //
        // Iterator<String> iterator = list.iterator();
        // while (iterator.hasNext()) {
        // iterator.next();
        // iterator.remove();
        // }

    }
}
