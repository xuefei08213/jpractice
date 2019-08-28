/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-21 12:34:36
 * @Description: TODO
 * @version V1.0
 */
public abstract class Block {

    public abstract void body() throws Exception;

    public Thread toThread() {
        return new Thread() {
            @Override
            public void run() {
                try {
                    body();
                } catch (Exception e) {
                    Block.throwAs(e);
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T) e;
    }

}
