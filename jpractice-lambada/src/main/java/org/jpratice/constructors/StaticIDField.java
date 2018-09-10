/**
 * 
 */
package org.jpratice.constructors;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-03 06:52:55
 * @Description: TODO
 * @version V1.0
 */
public class StaticIDField implements HasID {

    private static int counter = 0;
    private int id = counter++;

    public int getID() {
        return id;
    }

}
