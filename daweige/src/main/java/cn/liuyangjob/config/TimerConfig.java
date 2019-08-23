package cn.liuyangjob.config;

import cn.liuyangjob.task.TimerJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by  liuyang
 * 2019/8/23    14:22
 * cn.liuyangjob.config
 * All Right Reserved by liuyang.
 **/

@Configuration
public class TimerConfig {
    @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(TimerJob.class).withIdentity("testQuartz").storeDurably().build();
    }
    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(166)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}