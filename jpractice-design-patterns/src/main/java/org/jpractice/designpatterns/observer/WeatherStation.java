/**
 * 
 */
package org.jpractice.designpatterns.observer;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-11 08:40:51
 * @Description: TODO
 * @version V1.0
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
