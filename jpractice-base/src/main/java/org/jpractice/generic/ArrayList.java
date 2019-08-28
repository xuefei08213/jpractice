/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-11 20:46:41
 * @Description: TODO
 * @version V1.0
 */
public class ArrayList {

    private Object[] elementData;

    private int mod = 0;

    public ArrayList() {
        elementData = new Object[8];
    }

    public Object get(int index) {
        return elementData[index];
    }

    public void add(Object o) {
        elementData[mod] = o;
        mod++;
    }

}
