/**
 * 
 */
package org.jpractice.springboot.schedule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-26 16:55:33
 * @Description: TODO
 * @version V1.0
 */
@Component
public class OneMinuteTask {

    private static Logger logger = LogManager.getFormatterLogger(OneMinuteTask.class);

    @Scheduled(cron = "0 */1 * * * ?")
    public void taskOne() {
        System.out.println("开始执行");

        // try {
        // Thread.sleep(10 * 1000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        logger.info("task one");

    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void taskTwo() {
        logger.info("task two");
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void taskThree() {
        logger.info("task three");
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void taskFour() {
        logger.info("task four");
    }

}
