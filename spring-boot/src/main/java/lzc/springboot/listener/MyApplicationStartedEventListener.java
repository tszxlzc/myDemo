package lzc.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author liuzongchang
 * @create 2018-10-18 16:26
 **/
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {
	private Logger logger = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		logger.info("==MyApplicationStartedEventListener==   started");
	}
}
