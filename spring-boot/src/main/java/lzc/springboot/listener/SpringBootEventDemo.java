package lzc.springboot.listener;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by liuzc on 2018/10/19.
 */
@SpringBootApplication
public class SpringBootEventDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventDemo.class)
                .listeners(event -> {
                    //看输出有哪些事件类型
                    System.out.println("监听到事件：" + event.getClass().getName());
                })
                .run(args);
    }
}
