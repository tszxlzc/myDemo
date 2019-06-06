package lzc.demo.algorithm.leetcode;

/**
 * 时间区间合并
 * leetCode地址  https://leetcode.com/problems/merge-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * @author liuzongchang
 * @create 2019-06-06 16:39
 **/
public class MergeIntervalUtil {
	public static void main(String[] args) {

		int[][] input= {{1,3},{2,6},{8,10},{15,18}};
//		int[][] input= {{1,4},{4,5}};
		int[][] output = MergeIntervalUtil.merge(input);
		System.out.print("[");
		for (int i =0; i < output.length;i++){

			if(output[i][0] == 0 && output[i][1] ==0){
				break;
			}else {
				if(i > 0 ){
					System.out.print(",");
				}
				System.out.print("[" + output[i][0] + "," + output[i][1] + "]");
			}
		}
		System.out.print("]");

	}

	  /**
	  * 时间区间合并
	  * 思路：将已合并的区间放在输出数组，并通过记录已经初始化输出数组的下标区分下一个要初始化的值
	  * @author liuzongchang
	  * @version 1.0  2019/6/6 17:58
	  */
	public static int[][] merge(int[][] intervals){
		//定义输出数组
		int[][] out = new int[intervals.length][2];
		//记录输出数组初始化的下标
		int outIndex = 0;

		for(int i=0; i< intervals.length - 1; i++){
			// 记录上一次合并的值
			int[] pre;
			if (i == 0){
				pre = intervals[i];
			}else {
				pre = out[outIndex];
			}
			out[outIndex] = pre;

			int[] post = intervals[i + 1];
			if(pre[1] >= post[0]){
				//合并
				pre[1] = post[1];
			}else {
				//输出数组初始化下标进加一
				outIndex ++;
				out[outIndex] = post;
			}

		}

		return out;
	}
}
