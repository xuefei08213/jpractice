/**
 * 
 */
package org.jpractice.designpatterns.observer.embedded;

import java.util.Observable;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-11 09:20:43
 * @Description: TODO
 * @version V1.0
 */
public class WeatherData extends Observable {

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers(); // 采取推的模式
        // notifyObservers(Object arg); 观察者采取拉的模式
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
