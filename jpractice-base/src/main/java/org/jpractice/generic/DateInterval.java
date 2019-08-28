/**
 * 
 */
package org.jpractice.generic;

import java.time.LocalDate;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-13 23:46:13
 * @Description: TODO
 * @version V1.0
 */
public class DateInterval extends Pair<LocalDate> {

    @Override
    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }

    public static void main(String[] args) {
        DateInterval dateInterval = new DateInterval();
        Pair<LocalDate> pair = dateInterval;
        pair.setSecond(LocalDate.now());
    }
}
