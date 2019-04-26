package lzc.demo.juc;

/**
 * @author liuzongchang
 * @create 2019-04-15 15:51
 **/
public class JoinTest {

	private static volatile int x = 0, y = 0;
	private static volatile int a = 0, b = 0;
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
		a = 1;
		x = b;
		});
		Thread t2 = new Thread(() -> {
		b = 1;
		y = a;
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("x=" + x + "->y=" + y);
	}
}
