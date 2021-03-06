package lzc.demo.algorithm.leetcode;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @return
     */
    private static int remove(int[] nums, int val){
        int p= 0;
        int q= 0;
        while (q< nums.length){
            if(nums[q] == val){
                q++;
            }else {
                nums[p++] = nums[q++];
            }
        }

        return p;
    }

    private static int remove(int[] nums){
        int p=0;
        int q= 1;
        while (q< nums.length){
            if(nums[p] != nums[q]){
                nums[++p] = nums[q++];
            }else {
                q++;
            }
        }

        return p+1;
    }
}