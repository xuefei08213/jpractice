/**
 * 
 */
package org.jpractice.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-05 18:46:16
 * @Description: TODO
 * @version V1.0
 */
public class FirstChannel {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/xuefei/work/nio-data.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            // create buffer with capacity of 48 bytes
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);

            // read into buffer.
            int bytesRead = fileChannel.read(byteBuffer);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);

                // make buffer ready for read
                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {

                    // read 1 byte at a time
                    System.out.println((char) byteBuffer.get());
                }

                // make buffer ready for writing
                byteBuffer.clear();
                bytesRead = fileChannel.read(byteBuffer);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
