package lzc.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author liuzongchang
 * @create 2018-10-18 17:02
 **/
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
	private Logger logger = LoggerFactory.getLogger(MyApplicationPreparedEventListener.class);

	@Override public void onApplicationEvent(ApplicationPreparedEvent event) {
		ConfigurableApplicationContext cac = event.getApplicationContext();
		passContextInfo(cac);
	}

	private void passContextInfo(ApplicationContext cac) {
		//dosomething()
		logger.info("对上下文做了些操作");
	}
}
