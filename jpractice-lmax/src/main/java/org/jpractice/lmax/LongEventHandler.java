/**
 * 
 */
package org.jpractice.lmax;

import com.lmax.disruptor.EventHandler;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-31 10:58:04
 * @Description: create a consumer that will handle these events
 * @version V1.0
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event:" + longEvent.getValue());
    }

}
