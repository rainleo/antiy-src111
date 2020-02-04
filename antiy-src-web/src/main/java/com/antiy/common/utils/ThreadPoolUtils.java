package com.antiy.common.utils;

import java.util.concurrent.*;

/**
 * 描述:
 *
 * @author xuemeng
 * @create 2019-08-16 17:38
 */
public class ThreadPoolUtils {

    private static ExecutorService executor;

    private ThreadPoolUtils() {
    }

    /**
     * @Author: xuemeng
     * @Description: 创建线程池,这里是一次性线程池,主要用来应对突然的需要并行处理的业务。这里的线程请不要关闭,而是全局公用
     * @Date: 17:39 2019/8/16
     */
    public static synchronized ExecutorService getExecutor(){
        // TODO 这里可能需要表个数或者数据条数来定义线程池的参数
        if(executor == null){
            initExecutor();
        }
        return executor;
    }


    /**
     * @Author: xuemeng
     * @Description: 创建线程池,这里是一次性线程池,主要用来应对突然的需要并行处理的业务。这里的线程请自己關閉关闭
     * @Date: 10:05 2019/8/22
     */
    public static ExecutorService getCloseableExecutor(){
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(9999);
        ExecutorService exec = new ThreadPoolExecutor(3, 3, 120, TimeUnit.MINUTES, queue);
        return exec;
    }

    private static void initExecutor(){
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(99);
        ExecutorService exec = new ThreadPoolExecutor(5, 10, 120, TimeUnit.MINUTES, queue, new ThreadPoolExecutor.CallerRunsPolicy());
        executor = exec;
    }


}
