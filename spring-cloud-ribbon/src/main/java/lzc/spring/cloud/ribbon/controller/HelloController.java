package lzc.spring.cloud.ribbon.controller;

import lzc.spring.cloud.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzongchang
 * @create 2018-10-26 17:34
 **/
@RestController
public class HelloController {
	@Autowired
	private HelloService helloService;

	@GetMapping("hi")
	public String hi(@RequestParam String name){
		return helloService.hiService(name);
	}
}
