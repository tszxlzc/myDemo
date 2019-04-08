package lzc.springboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

	/**
	 * com.github.pagehelper.PageHelper  分页
	 * @return
	 * @author liuzongchang
	 * @date 2019/4/8 15:11
	 */
	@GetMapping("page_ttt")
	public List<TttPO> pageTtt(Integer pageNum){
		if(pageNum == null){
			pageNum =1;
		}
		Page page =  PageHelper.startPage(pageNum,2);
		List<TttPO> list = tttMapper.listTtt();
		System.out.println(page.getTotal());
		return list;
	}
}
