package lzc.springboot;

import lzc.springboot.listener.MyApplicationEnvironmentPreparedEventListener;
import lzc.springboot.listener.MyApplicationFailedEventListener;
import lzc.springboot.listener.MyApplicationPreparedEventListener;
import lzc.springboot.listener.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args)


		//添加监听器
		SpringApplication  application = new SpringApplication(Application.class);
		application.addListeners(new MyApplicationStartedEventListener(),
				new MyApplicationEnvironmentPreparedEventListener(),
				new MyApplicationPreparedEventListener(),
				new MyApplicationFailedEventListener());

		application.run();
	}
}
