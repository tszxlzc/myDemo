package lzc.demo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 用来控制同时访问特定资源的线程数量，通过协调保证合理的使用公共资源
 *
 *  比作控制车流的红绿灯，如马路要控制流量，只限制100辆车通行，其他必须在路口处等待
 * ，不能行驶在马路上，当其中有5辆离开马路，那么允许后面5辆进入马路。
 * 例子中的车就是线程，驶入马路表示线程正在执行，离开马路表示线程执行完成，看见红灯表示被阻塞。
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("一辆车上路");
                        s.acquire();
                        System.out.println("行驶中");
                        s.release();
                        System.out.println("离开一辆");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        pool.shutdown();
    }
}
