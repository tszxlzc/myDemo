package lzc.spring.cloud.feign.hystrix;

import lzc.spring.cloud.feign.clients.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author liuzongchang
 * @create 2018-10-29 11:08
 **/
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {

	@Override public String sayHiFromClient(String name) {
		return "sorry " + name;
	}
}
