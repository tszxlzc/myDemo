package lzc.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello world
 *
 * @author liuzongchang
 * @create 2018-10-18 15:54
 **/
@RestController
@RequestMapping("springboot")
public class HelloWorldController {
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public  String sayHello(@PathVariable("name") String name){
		return  "hello " + name;
	}
}
