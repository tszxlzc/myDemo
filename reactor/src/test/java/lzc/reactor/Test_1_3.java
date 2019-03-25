package lzc.reactor;

import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author liuzongchang
 * @create 2018-11-01 15:23
 **/
public class Test_1_3 {

	/**
	 * 1. 响应式之道 - 3 快速上手 - 2 Reactor
	 * <p>
	 * 基本的Flux和Mono序列，以及订阅。
	 */
	@Test
	public void testSimpleFluxMono() {

		// 1. 用just声明数据流
		Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print);
		System.out.println();
		Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::println, System.err::println, () -> System.out.println("Completed!"));
		Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
		Flux.fromArray(array);
		List<Integer> list = Arrays.asList(array);
		Flux.fromIterable(list);
		Stream<Integer> stream = list.stream();
		Flux.fromStream(stream);
		Mono.just(1).subscribe(System.out::println);

		// 2. 只有完成或错误信号的数据流
		Flux.just();
		Flux.empty();
		Flux.error(new Exception("some error"));
		Mono.empty();
		Mono.justOrEmpty(Optional.empty());
		System.out.println("---Mono.error---");
		Mono.error(new Exception("some error")).subscribe(
				System.out::println,
				System.err::println,
				() -> System.out.println("Completed!"),
				s -> System.out.println("Subscribed!")
		);
	}

	private Flux<Integer> gererateFluxFrom1To6(){
		return Flux.just(1,2,3,4,5,6);
	}

	private Mono<Integer> generateMonoWithErro(){
		return Mono.error(new Exception("some error"));
	}

	/**
	 * 1. 响应式之道 - 3 快速上手 - 2 Reactor
	 * <p>
	 * 使用StepVerifier进行单测。
	 */
	@Test
	public void testViaStepVerifier(){
		StepVerifier.create(gererateFluxFrom1To6())
				.expectNext(1,2,3,4,5,6)
				.expectComplete()
				.verify();

		StepVerifier.create(generateMonoWithErro())
				.expectErrorMessage("some error")
				.verify();
	}

	/**
	 * 1. 响应式之道 - 3 快速上手 - 2 Reactor
	 * <p>
	 * 测试基本的Operator。
	 */
	@Test
	public void testSimpleOperators() throws InterruptedException {
		//map
		StepVerifier.create(Flux.range(1,6)
						.map(i->i * i))
					.expectNext(1,4,9,16,25,36)
					.expectComplete();

		//flatMap
		StepVerifier.create(Flux.just("flux","mono")
						.flatMap(s -> Flux.fromArray(s.split("\\s*"))
						.delayElements(Duration.ofMillis(100)))
						.doOnNext(System.out::println))
					.expectNextCount(8)
					.verifyComplete();

		//filter
		StepVerifier.create(Flux.range(1,6)
						.filter(i-> i%2 ==1)
						.map(i -> i * i))
					.expectNext(1,9,25)
			        .verifyComplete();

		// zip
		CountDownLatch countDownLatch = new CountDownLatch(1);
		Flux.zip(
				getZipDescFlux(),
				Flux.interval(Duration.ofMillis(200)))
				.subscribe(t -> System.out.println(t.getT1()), null, countDownLatch::countDown);
		countDownLatch.await(10, TimeUnit.SECONDS);

	}

	private Flux<String> getZipDescFlux() {
		String desc = "Zip two sources together, that is to say wait for all the sources to emit one element and combine these elements once into a Tuple2.";
		return Flux.fromArray(desc.split("\\s+"));  // 1
	}

	/**
	 * 同步转异步
	 * @return
	 * @author liuzongchang
	 * @date 2018/11/1 17:30
	 */
	@Test
	public void testSyncToAsync() throws InterruptedException{
		CountDownLatch countDownLatch = new CountDownLatch(1);

		Mono.fromCallable(()->getStringSync())
				.subscribeOn(Schedulers.elastic())
				.subscribe(System.out::println, null, countDownLatch::countDown);

		System.out.println("=========在同步方法getStringSync执行之前打印，说明异步成功了=======");

		countDownLatch.await(10,TimeUnit.SECONDS);
	}

	private String getStringSync(){
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello, Reactor!";
	}


	/**
	 * 背压测试
	 * @return
	 * @author liuzongchang
	 * @date 2018/11/1 17:59
	 */
	@Test
	public void testBackpressure() {
		Flux.range(1, 100)    // 1
				.doOnRequest(n -> System.out.println("Request " + n + " values..."))    // 2
				.subscribe(new BaseSubscriber<Integer>() {  // 3
					@Override
					protected void hookOnSubscribe(Subscription subscription) { // 4
						System.out.println("Subscribed and make a request...");
						request(1); // 5
					}

					@Override
					protected void hookOnNext(Integer value) {  // 6
//						try {
////							TimeUnit.SECONDS.sleep(1);  // 7
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
						System.out.println("Get value [" + value + "]");    // 8
						request(10); // 9
					}
				});
	}
}
