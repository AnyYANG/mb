package cn.liuyangjob.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by  liuyang
 * 2019/7/25    20:50
 * cn.liuyangjob.ManyThread
 * All Right Reserved by liuyang.
 **/

/**
 * 这是一个单例模式的线程池
 */
public class MyThreadFactory {
    private MyThreadFactory() {
    }

    //这个是线程池
    private static ExecutorService threadPool;

    public static ExecutorService getExecutorService() {
        if(threadPool == null){
            ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("线程-demo-%d").build();
             // ctrl +p 可以看到每个参数的作用
            threadPool =new ThreadPoolExecutor(20,50,1,TimeUnit.SECONDS,new LinkedBlockingQueue(),threadFactory);
        }
        return threadPool;
    }
}
