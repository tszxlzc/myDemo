package lzc.demo.multiThread;

/**
 * 创建多线程
 *
 * @author liuzongchang
 * @create 2018-06-06 21:34
 **/
public class ThreadN {
	public static void  main(String[] args) throws InterruptedException {
		final Object  lock = new Object();
		for(int i =0; i< 10000; i++){
			new Thread(new Runnable() {
				public void run() {
//						synchronized (ThreadN.class){
						synchronized (lock){
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
				}
			}).start();
			System.out.println("线程" + i +"启动");
		}


		Thread.sleep(100000);
//		synchronized (ThreadN.class){
		synchronized (lock){
			lock.notifyAll();
		}
	}
}
