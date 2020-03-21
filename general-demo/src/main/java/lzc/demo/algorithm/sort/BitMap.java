/**
 *  * 题目：
 *  已知某个文件包含一些电话号码，每个号码为8位数字，统计不同号码的个数
 *
 *  题目还可以转化为：
 *  1） 10亿个正整数，只有1个数重复出现过，要求在O(n) 的时间里找出这个数
 *  2）给定a、b两个问，各存放50亿个URL，每个URL各占用64bytes，要求在O(n)的时间里找出a、b文件的共同URL
 *  3）给40亿个不重复的无符号整数（没排过序），然后再给一个数，如何快速判断这个数是否在那40亿个数当中？
 *
 *  位图算法适用场景：
 *  在海量数据中查出重复出现的元素或者去除重复出现的元素
 */
package lzc.demo.algorithm.sort;

import java.util.Random;

public class BitMap {
    int arrNum = 100;
    // 8位号码最小值
    int mMin = 10000000;
    // 8位号码最大值
    int mMax = 99999999;
    // 计算最大值和最小值之间电话号码的数量
    int N = mMax - mMin;
    //每个单词（这里是int）代表的位数
    int BITS_PER_WORD = 32;
    //单词偏移的位数，体现为数组的下标
    int WORD_OFFSET(int b){
        return b/BITS_PER_WORD;
    }
    //整数中偏移的二进制位数， 例如1000 0000 - 1000 0000偏移0位；1000 0001 - 1000 0000偏移1位
    int BIT_OFFSET(int b){
        return b % BITS_PER_WORD;
    }

    /**
     * 设置n的二进制位
     * @param words  首先要找到n 在words 数组中的下标
     * @param n
     */
    void setBit(int[] words, int n){
        n-= mMin;
        words[WORD_OFFSET(n)] |= (1<<BIT_OFFSET(n));
    }

    /**
     * 清除n 占用的二进制位
     * @param words 首先要找到n 在words 数组中的下标
     * @param n
     */
    void clearBit(int[] words, int n){
        words[WORD_OFFSET(n)] &= ~(1<<BIT_OFFSET(n));
    }

    /**
     * 获取bit位
     * @param words
     * @param n
     * @return
     */
    boolean getBit(int[] words, int n){
        int bit = words[WORD_OFFSET(n)] &(1<< BIT_OFFSET(n));
        return bit !=0;
    }

    public void sort(){
        int arr[] = new int[arrNum];
        System.out.println("数组大小：" + arrNum);

        //初始化存储所有电话号码的数组
        int words[] = new int[1 + N/BITS_PER_WORD] ;

        // 准备测试数据
        Random random = new Random();
        for ( int j =0; j< arrNum; j++){
            arr[j] = random.nextInt(N);
            arr[j] += mMin;
            System.out.println(arr[j] + "  ");
        }

        System.out.println();

        //放置到数组，及数组元素代表的二进制位上； 也就进行了排序
        for (int j=0; j<arrNum; j++){
            setBit(words,arr[j]);
        }

        int count = 0;
        System.out.println("排序后 arr数组为：");
        for (int j=0;j<N;j++){
            if(getBit(words,j)){
                System.out.print(j + mMin + "  ");
                count ++;
            }
        }

        System.out.println();
        System.out.println("总个数为： " + count);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new BitMap().sort();

        System.out.println("耗时毫秒数： " + (System.currentTimeMillis() - start));
    }

}