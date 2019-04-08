package lzc.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置要扫描的mapper
 * @author liuzongchang
 * @create 2019-04-08 14:13
 **/
@Configuration
@MapperScan("lzc.springboot.mapper")
public class MapperConfigure {
}
