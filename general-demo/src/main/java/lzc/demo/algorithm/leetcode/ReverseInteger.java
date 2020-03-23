package lzc.demo.algorithm.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.print(reverse(-1123));
    }

    public static int reverse(int x){
        int ret = 0;
        while (x !=0){
            // 首位
            int pop = x %10;
            //防止最大值溢出
            if(ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE/10 && pop ==7)){
                return 0;
            }
            //防止最小值溢出
            if(ret < Integer.MIN_VALUE/10 ||(ret == Integer.MIN_VALUE/10 && pop < -8)){
                return 0;
            }

            ret = ret * 10 + pop;
            x = x/10;
        }

        return ret;
    }
}