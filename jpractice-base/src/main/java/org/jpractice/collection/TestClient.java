/**
 * 
 */
package org.jpractice.collection;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-31 12:33:53
 * @Description: TODO
 * @version V1.0
 */
public class TestClient {

    public static void main(String[] args) {

        SimpleDateFormat sdfdayhm = new SimpleDateFormat("yyyyMMddHHmm");
        sdfdayhm.format(null);

        System.out.println(new Date(1541915010729L));
        // System.out.println(7 >>> 1);
        // System.out.println(1 << 30);
        System.out.println(tableSizeFor(6));
        System.out.println(tableSizeFor(7));
        System.out.println(tableSizeFor(8));
        System.out.println(tableSizeFor(9));
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
