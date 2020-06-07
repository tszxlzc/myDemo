package lzc.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        int corePoolSize = 20;
        int maximumPoolSize = 200;
        long keepAliveTime = 10;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1000);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                workQueue, Executors.defaultThreadFactory(), handler);
        // 预启动所有核心线程
        executor.prestartAllCoreThreads();

        return executor;
    }
}