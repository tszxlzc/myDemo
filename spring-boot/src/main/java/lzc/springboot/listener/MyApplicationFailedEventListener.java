package lzc.springboot.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;


/**
 * @author liuzongchang
 * @create 2018-10-18 17:07
 **/
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {
	@Override public void onApplicationEvent(ApplicationFailedEvent event) {
		Throwable throwable = event.getException();
		handleThrowable(throwable);
	}

	/**
	 * 处理异常
	 * @return
	 * @author liuzongchang
	 * @date 2018/10/18 17:09
	 */
	private void handleThrowable(Throwable throwable){

	}

}
