/**
 * 
 */
package org.jpractice.designpatterns.observer.embedded;

import java.util.Observable;
import java.util.Observer;

import org.jpractice.designpatterns.observer.DisplayElement;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-11 09:35:41
 * @Description: TODO
 * @version V1.0
 */
public class ForecastDisplay implements Observer, DisplayElement {

    Observable observable;

    private float currentPresssure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = this.currentPresssure;
            currentPresssure = weatherData.getPressure();
            display();
        }
    }

}
