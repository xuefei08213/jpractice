/**
 * 
 */
package org.jpractice.designpatterns.observer;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-11 08:35:38
 * @Description: TODO
 * @version V1.0
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Current conditions: %s F degress and %s%% humidity", temperature, humidity));
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

}
