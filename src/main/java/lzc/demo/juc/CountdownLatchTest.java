package lzc.demo.juc;

import java.util.concurrent.CountDownLatch;

/**
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

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("执行结束");
	}
}
