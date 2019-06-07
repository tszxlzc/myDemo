package lzc.demo.algorithm.leetcode;

/**
 *  聪明的⼩偷（建议时间复杂度 O(n) ）
 * 有一个职业⼩偷，打算盗窃某个圆形广场上的沿街商铺。每间商铺内都存放了了
 * ⼀定金额的现金。所有商铺围绕广场形成了一个环，即第⼀间商铺与最后一间
 * 商铺也是相邻的。同时，每两间相邻的商铺之间都连接了一套报警系统（包括
 * 第⼀间和最后⼀间商铺之间）。如果两间相邻的商铺在同一个晚上同时被偷，
 * 就会自动触发报警系统。
 * 给定一个非负整数数组，表示每间商铺中存放的⾦额，请问，在不触发报警系
 * 统的前提下，这位职业小偷一个晚上总共最多能偷到多少金额？
 * 例例1：输⼊入： [2,3,2]
 * 返回： 3
 * 解释：因为房间1（金额=2）和 房间3（金额=2）也是相邻的，所以不能
 * 同时偷这两个，那就只能偷金额最大的房间 2（金额=3）
 * 例例 2：输⼊入：[1,2,3,1]
 * 返回：4
 * 解释: 从房间1 (⾦额=1) 和 房间3 (⾦额=3)可以偷取最⼤的⾦额 1+3=4
 * 注意：数组中所有元素相加不会超过 20 亿
 * 需要实现的⽅方法原型： int steal(int[] nums)
 *
 * @author liuzongchang
 * @create 2019-06-07 9:16
 **/
public class StealUtil {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1,1,3,1000};
		System.out.println(steal(nums));
		int[] nums1 = {2,3,2};
		System.out.println(steal(nums1));
	}

	public static int steal(int[] nums){
        int n = nums.length;
        if(n == 0) {
        	return 0;
        }
        if(n==1){
        	return nums[0];
        }
        int ppre = nums[0];
        int pre = ppre>nums[1]?ppre:nums[1];
        for (int i= 2; i<n;i++){
        	int now = ppre + nums[i];
        	ppre = pre;
        	pre = now>pre?now : pre;
        }

        return pre;
	}
}
