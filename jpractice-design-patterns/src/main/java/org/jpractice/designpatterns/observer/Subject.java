/**
 * 
 */
package org.jpractice.designpatterns.observer;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-10 07:20:32
 * @Description: TODO
 * @version V1.0
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver();

}
