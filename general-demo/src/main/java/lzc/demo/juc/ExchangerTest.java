package lzc.demo.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程之间的数据交换，提供一个同步点，两个线程可以交换彼此数据，通过exchange()交换数据，当两个线程都执行到exchange()方法，可以将本线程的数据传递给对方。
 * 应用场景:  1)遗传算法  2)校对工作
 */
public class ExchangerTest {

    private static ExecutorService pool = Executors.newFixedThreadPool(2);
    private static Exchanger<String> exchanger = new Exchanger<>();
    public static void main(String[] args) {
        pool.execute(()->{
            String A = "B";
            try {
               String B =  exchanger.exchange(A);
               System.out.println("A 交换获取到的返回值B为【" + B  +"】");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.execute(()->{
            try {
                String B = "B";
                String A = exchanger.exchange(B);
                System.out.println("是否一致   " + A.equalsIgnoreCase(B)+"   A:::"+A+"   B:::"+B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
