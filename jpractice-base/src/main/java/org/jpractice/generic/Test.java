/**
 * 
 */
package org.jpractice.generic;

import java.io.File;
import java.util.Scanner;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-21 12:39:07
 * @Description: TODO
 * @version V1.0
 */
public class Test {

    public static void main(String[] args) {
        new Block() {

            @Override
            public void body() throws Exception {
                Scanner in = new Scanner(new File("ddd"));
                while (in.hasNext()) {
                    System.out.println(in.next());
                }
            }
        }.toThread().start();
    }
}
