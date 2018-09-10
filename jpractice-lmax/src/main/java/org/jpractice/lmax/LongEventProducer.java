/**
 * 
 */
package org.jpractice.lmax;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-31 11:00:30
 * @Description: source for these events
 * @version V1.0
 */
public class LongEventProducer {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * It requires(at the lowest level) a 2-phase approach to message publication
     * claim the slot in the ring buffer then publish the available data
     * 
     * it is also necessary to wrap publication in try/finally block.
     * if we claim a slot in the Ring Buffer(calling RingBuffer.next()) then we must publish the sequence.
     * Failing to do so can result in corruption of the state of the Disruptor.
     * 
     * 
     * @param byteBuffer
     */
    public void onData(ByteBuffer byteBuffer) {
        long sequence = ringBuffer.next(); // Grab the next sequence
        try {
            LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            event.setValue(byteBuffer.getLong(0)); // Fill with data
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ringBuffer.publish(sequence);
        }

    }
}
