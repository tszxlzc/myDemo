package lzc.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * @author liuzongchang
 * @create 2018-10-18 16:54
 **/
public class MyApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
	private Logger logger = LoggerFactory.getLogger(MyApplicationEnvironmentPreparedEventListener.class);

	@Override public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment envi = event.getEnvironment();
		MutablePropertySources mps = envi.getPropertySources();
		if (mps != null) {
			Iterator<PropertySource<?>> iter = mps.iterator();
			while (iter.hasNext()) {
				PropertySource<?> ps = iter.next();
				logger
						.info("ps.getName:{};ps.getSource:{};ps.getClass:{}", ps.getName(), ps.getSource(), ps.getClass());
			}
		}
	}
}
