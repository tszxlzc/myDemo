package lzc.spring.cloud.nativeApp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableAutoConfiguration
public class SpringBootApplicationBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setId("小马哥");
        context.refresh();

        new SpringApplicationBuilder(SpringBootApplicationBootstrap.class)
                .parent(context) // 显式地设置双亲上下文
                .run(args);
    }

}