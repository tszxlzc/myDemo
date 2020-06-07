package lzc.demo.juc;

import java.util.Map;
import java.util.concurrent.*;

/**
 * CountDownLatch和CyclicBarrier区别
 * 1.CountDownLatch只能用一次，CyclicBarrier可以reset(),且适合处理更复杂的业务
 * 2. CyclicBarrier还有getNumberWaiting 获取当前阻塞的线程数量，isBroken()了解阻塞线程是否被中断
 *
 *
 * 应用场景： 银行流水处理服务，模拟Excel统计多个sheet汇总
 */
public class CyclicBarrierTest implements Runnable {

    private CyclicBarrier c = new CyclicBarrier(4,this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();


    private void count(){
        for (int i=0;i<4;i++){
            final String index_thread = i + "";
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCount.put(index_thread+"",1);
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String,Integer> sheet: sheetBankWaterCount.entrySet()
        ) {
            result += sheet.getValue();
        }
//        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        CyclicBarrierTest bankWaterService = new CyclicBarrierTest();
        //计算多次， 验证CyclicBarrier 是可以循环使用的
        bankWaterService.count();
        bankWaterService.count();
        bankWaterService.count();
    }
}
