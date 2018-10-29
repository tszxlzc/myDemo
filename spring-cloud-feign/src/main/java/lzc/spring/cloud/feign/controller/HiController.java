package lzc.spring.cloud.feign.controller;

import lzc.spring.cloud.feign.clients.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzongchang
 * @create 2018-10-29 10:29
 **/
@RestController
public class HiController {
	@Autowired
	private SchedualServiceHi schedualServiceHi;

	@GetMapping(value = "hi")
	public String sayHi(@RequestParam(value = "name")String name){
		return schedualServiceHi.sayHiFromClient(name);
	}
}
