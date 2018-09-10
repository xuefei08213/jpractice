/**
 * 
 */
package org.jpractice.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-10 07:25:11
 * @Description: TODO
 * @version V1.0
 */
public class WeatherData implements Subject {

    private List<Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    /* (non-Javadoc)
     * @see org.jpractice.designpatterns.observer.Subject#registerObserver(org.jpractice.designpatterns.observer.Observer)
     */
    @Override
    public void registerObserver(Observer observer) {
        // TODO Auto-generated method stub
        observers.add(observer);
    }

    /* (non-Javadoc)
     * @see org.jpractice.designpatterns.observer.Subject#removeObserver(org.jpractice.designpatterns.observer.Observer)
     */
    @Override
    public void removeObserver(Observer observer) {
        // TODO Auto-generated method stub
        int index = observers.indexOf(observer);
        if (index > 0) {
            observers.remove(index);
        }
    }

    /* (non-Javadoc)
     * @see org.jpractice.designpatterns.observer.Subject#notifyObserver()
     */
    @Override
    public void notifyObserver() {
        // TODO Auto-generated method stub
        observers.stream().forEach(observer -> {
            observer.update(temperature, humidity, pressure);
        });
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementsChanged();
    }

}
