package lzc.spring.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuzongchang
 * @create 2018-10-26 17:29
 **/
@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiErro")
	public String hiService(String name){
		return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
	}

	public String hiErro(String name){
		return "hi" + name + ", sorry error!";
	}
}
