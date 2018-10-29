package lzc.spring.cloud.feign.clients;

import lzc.spring.cloud.feign.hystrix.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @return
 * @author liuzongchang
 * @date 2018/10/29 10:29
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {

	/**
	 * 调用hi接口
	 * @param name
	 * @return
	 * @author liuzongchang
	 * @date 2018/10/29 10:27
	 */
	@GetMapping(value = "hi")
	String sayHiFromClient(@RequestParam(value = "name") String name);
}
