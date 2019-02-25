package lzc.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liuzc on 2018/10/25.
 */
@SpringBootApplication
public class SpringRestApplication {
    public static void main(String[] args) {
        new SpringApplication(SpringRestApplication.class).run(args);
    }
}
