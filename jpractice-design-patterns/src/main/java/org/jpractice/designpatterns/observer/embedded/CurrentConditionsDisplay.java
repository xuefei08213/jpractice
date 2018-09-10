/**
 * 
 */
package org.jpractice.designpatterns.observer.embedded;

import java.util.Observable;
import java.util.Observer;

import org.jpractice.designpatterns.observer.DisplayElement;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-11 09:27:17
 * @Description: TODO
 * @version V1.0
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;

    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Current conditions: %s F degress and %s%% humidity", temperature, humidity));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getPressure();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

}
