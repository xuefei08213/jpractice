/**
 * 
 */
package org.jpractice.log;

import java.util.Random;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-02-22 09:35:10
 * @Description: TODO
 * @version V1.0
 */
public class Test {

    public static void main(String[] args) {
        Random r = new Random();
        int low = 100;
        int high = 200;
        int result = r.nextInt(high - low) + low;
        System.out.println(result);
    }
}
