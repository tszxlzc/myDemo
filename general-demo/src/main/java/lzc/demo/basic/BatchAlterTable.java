package lzc.demo.basic;

/**
 * tai_homework_student_detail进行了分表，分表后表结构是一致的，只是表名不一样，组成方式为：tai_homework_student_detail_ + 数字
 * @author liuzongchang
 * @create 2018-05-07 19:08
 **/
public class BatchAlterTable {
	public static  void  main (String[] args){
//		alterTable();

//		changeColumn();

		rollback();
	}

	private static void changeColumn(){
		for(int i =0; i< 30; i++){
			System.out.println("ALTER TABLE tai_homework_student_detail_" + i + " CHANGE `listen_sub_question_id`  `biz_sub_id` bigint(20) DEFAULT 0 COMMENT 'biz_id为试卷id时，biz_sub__id代表试卷子题id';");
			System.out.println();
		}
	}
	/**
	 * 修改表结构
	 * @return
	 * @author liuzongchang
	 * @date 2018/5/9 17:03
	 */
	private static void alterTable(){
		for(int i =0; i< 30; i++){
			System.out.println("ALTER TABLE tai_homework_student_detail_" + i);
			System.out.println("MODIFY COLUMN `biz_type` int(10) DEFAULT NULL COMMENT '类型（1：试题；2：课节 3:听力）',");
			System.out.println("MODIFY COLUMN `biz_id` bigint(20) DEFAULT NULL COMMENT '课节/试题编号/试卷id',");
			System.out.println("MODIFY COLUMN `answer_time` bigint(20) DEFAULT NULL COMMENT '试题答题时长/听力单元题答题时长（单位：毫秒）',");
			System.out.println("DROP INDEX `uk_student_howework_quesiton`,");
			System.out.println("ADD COLUMN `question_type` int(11) DEFAULT NULL COMMENT '【题目类型，1-选择题 2-填空题 3-图片选择题 4-图片填空题】',");
			System.out.println("ADD COLUMN `listen_unit_id` bigint(20) DEFAULT NULL COMMENT '听力单元题id',");
			System.out.println("ADD COLUMN `biz_sub_id` bigint(20) DEFAULT 0 COMMENT 'biz_id为试卷id时，biz_sub_id代表试卷子题id';");
			System.out.println("-- 重建新的索引");
			System.out.println("ALTER TABLE tai_homework_student_detail_" + i);
			System.out.println("ADD UNIQUE KEY `uk_student_homework_question` (`homework_id`,`student_id`,`biz_type`,`biz_id`,`biz_sub_id`) USING BTREE COMMENT '唯一索引：保证学生提交试题的唯一性';");
			System.out.println("");
		}
	}


	/**
	 * 回滚表结构
	 * @return
	 * @author liuzongchang
	 * @date 2018/5/9 17:03
	 */
	private static void rollback(){
		for(int i = 0; i < 30; i++){
			System.out.println("ALTER TABLE tai_homework_student_detail_" + i);
			System.out.println("MODIFY COLUMN `biz_type` int(10) DEFAULT NULL COMMENT '类型（1：试题；2：课节）',");
			System.out.println("MODIFY COLUMN `biz_id` bigint(20) DEFAULT NULL COMMENT '课节/试题编号',");
			System.out.println("MODIFY COLUMN `answer_time` bigint(20) DEFAULT NULL COMMENT '答题时长（单位：毫秒）',");
			System.out.println("DROP INDEX `uk_student_homework_question`,");
			System.out.println("DROP COLUMN `question_type`,");
			System.out.println("DROP COLUMN `listen_unit_id`,");
			System.out.println("DROP COLUMN `biz_sub_id`;");
			System.out.println("-- 添加回原来的索引");
			System.out.println("ALTER TABLE tai_homework_student_detail_" + i);
			System.out.println("ADD UNIQUE KEY `uk_student_howework_quesiton` (`homework_id`,`student_id`,`biz_type`,`biz_id`) USING BTREE COMMENT '唯一索引：保证学生提交试题的唯一性';");
			System.out.println("");
		}

	}
}
