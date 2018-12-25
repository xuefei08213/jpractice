/**
 * 
 */
package org.jpractice.collection.hashmap;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-11-02 07:01:17
 * @Description: TODO
 * @version V1.0
 */
public class TestElement {

    private String name;

    public TestElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 3;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
