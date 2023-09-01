package com.mgy.official.account.service.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author mgy
 * @date 2023/8/31
 */
@Component //  定义任务实现类
public class OfficialAccountJob {

    /**
     * 但是spring的@Scheduled只支持6位，年份是不支持的，带年份的7位格式会报错：
     * Cron expression must consist of 6 fields (found 7 in "1/5 * * * * ? 2018")
     *
     * @Scheduled 注解表示当前方法就是一个任务调度执行对象
     * 通过cron表达式 来配置 该方法的执行周期
     **/

    //  0 0 1 * * ? 每天早上1点
    @Scheduled(cron = "0 0 1 * * ?")
    public void run() {
        System.out.println("----执行扫描一次--- time=1分钟" + System.currentTimeMillis());
    }


//    @Scheduled(cron = "*/2 * * * * ?")
    public void run1() {
        System.out.println("----执行扫描一次--- time=2s" + System.currentTimeMillis());
    }


//    @Scheduled(cron = "*/3 * * * * ?")
    public void run2() {
        System.out.println("----执行扫描一次--- time=3s" + System.currentTimeMillis());
    }

}
