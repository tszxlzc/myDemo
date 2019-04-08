package lzc.springboot.controller;

import lzc.springboot.mapper.TttMapper;
import lzc.springboot.model.TttPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuzongchang
 * @create 2019-04-08 14:05
 **/
@RestController
@RequestMapping("mybatis")
public class MybatisController {

	@Autowired
	private TttMapper tttMapper;

	@GetMapping("list_ttt")
	public List<TttPO> listTtt(){
		return tttMapper.listTtt();
	}
}
