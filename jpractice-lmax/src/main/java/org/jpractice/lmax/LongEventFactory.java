/**
 * 
 */
package org.jpractice.lmax;

import com.lmax.disruptor.EventFactory;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-31 10:56:27
 * @Description: TODO
 * @version V1.0
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }

}
