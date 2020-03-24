package lzc.demo.algorithm.leetcode;

import java.util.Arrays;

public class Rob {
    public static void main(String[] args) {

    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public int rob_1(int[] num){
        int preMax = 0;
        int currMax = 0;
        for(int x : num){
            int temp = currMax;
            currMax = Math.max(preMax + x, currMax);
            preMax = temp;
        }

        return currMax;
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int rob_2(int[] nums){
        if(nums.length ==0){
            return 0;
        }

        //只有一个没有相连的也不会触发报警
        if(nums.length == 1){
            return nums[0];
        }
        //将环形打断，分为包含nums[0]且不包含nums[length-1]  和不包含nums[0]且包含nums[length-1]
        return Math.max(rob_1(Arrays.copyOfRange(nums,0,nums.length-1)),
                rob_1(Arrays.copyOfRange(nums,1,nums.length)));
    }



}