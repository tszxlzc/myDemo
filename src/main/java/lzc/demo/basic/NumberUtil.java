package lzc.demo.basic;

import java.util.Random;

/**
 * 数字处理工具类
 *
 * @author liuzongchang
 * @create 2018-03-23 15:32
 **/
public class NumberUtil {

	public static void main(String[] args){
		int[] result = randomArray(5,20,5);
		for (int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
	}

	/**
	 * 随机指定范围内N个不重复的数，不会包含最大数
	 * 在初始化的无重复待选数组中随机产生一个数放入结果中，
	 * 将待选数组被随机到的数，用待选数组（len - 1）下标对应的数替换，然后从len-2里随机产生下一个随机数，如此类推
	 * @param max 指定范围最大值
	 * @param min 指定范围最小值
	 * @param n 随机数个数
	 * @return int[] 随机数结果集，不会包含最大数
	 * @author liuzongchang
	 * @date 2018/2/28 10:44
	 */
	private static int[] randomArray(int min, int max, int n){
		int len = max - min;
		if(max < min || n > len){
			return null;
		}

		//初始化给定范围的待选数组
		int[] source = new int[len];
		for(int i = min; i < min + len; i++){
			source[i-min] = i;
		}

		int[] result = new int[n];
		Random rd = new Random();
		int index;
		for(int i = 0; i< result.length; i++){
			//待选数组0到len-1随机一个下标
			index  = Math.abs(rd.nextInt() % len--);
			//将随机到的数放入结果集
			result[i] = source[index];
			//将待选数组中被随机到的数（source[index]），用待选数组len-1下标对应的数替换
			source[index] = source[len];
		}
		return result;
	}
}
