/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-18 12:32:37
 * @Description: TODO
 * @version V1.0
 */
public class ArrayAlgMethod {

    @SuppressWarnings("unchecked")
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static void main(String[] args) {
        String midStr = ArrayAlgMethod.getMiddle("jonh", "Q", "public");
        System.out.println(midStr);
        ArrayAlgMethod.getMiddle(3.14, 1726, 0);
    }
}
