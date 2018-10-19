package lzc.springboot.controller;

import lzc.springboot.module.User;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private User user;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public  String sayHello(@PathVariable("name") String name){
		System.out.println("UserName: " + user.getName());
		System.out.println("user信息为: " + user);
		return  "hello " + name;
	}
}
