package cn.liuyangjob.task;

import cn.liuyangjob.JoinService.JoinerService;
import cn.liuyangjob.bean.PlatformActivitiesJoin;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by  liuyang
 * 2019/8/23    14:20
 * cn.liuyangjob.task
 * All Right Reserved by liuyang.
 **/

public class TimerJob extends QuartzJobBean {


    @Resource
    JoinerService joinerService;
    /**
     * 执行定时任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz task "+new Date());

    }
}