package lzc.demo.juc;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 用过Thread的join()都知道，join让“主线程”等待“子线程”结束之后才能继续运行。
 * jdk1.5之后提供了CountDownLatch提供了比join更加丰富的功能，是一种共享锁
 * countDown() n - -; 释放共享锁
 * await() n==0 线程执行;
 *
 * @author liuzongchang
 * @create 2018-08-10 13:24
 **/
public class CountdownLatchTest {
	public static void main(String[] args){
		int concurrent = 20;
		CountDownLatch countDownLatch = new CountDownLatch(concurrent);


		for(int i=0; i < concurrent; i++){
			countDownLatch.countDown();
			System.out.println(i);
		}

		/**
		 * 可以看出countDownLatch也可以实现join的 功能，而且更强大；countDownLatch可以让主线程等待多个子线程完成后继续
		 */
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("执行结束");
	}
}
