package lzc.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liuzc on 2018/10/20.
 */
@SpringBootApplication
public class ThymeleafApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ThymeleafApplication.class);
        springApplication.run(args);
    }
}
