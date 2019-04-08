package lzc.springboot.mapper;

import lzc.springboot.model.TttPO;

import java.util.List;

/**
 * 测试mapper
 * @return
 * @author liuzongchang
 * @date 2019/4/8 14:03
 */
public interface TttMapper {

	/**
	 * 查询列表
	 * @return
	 * @author liuzongchang
	 * @date 2019/4/8 14:04
	 */
	List<TttPO> listTtt();
}
