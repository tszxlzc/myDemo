package lzc.demo.algorithm;

import java.util.Random;

/**
 * 一个数组中有0-99共100个数，要求在在O（n）的时间内打乱这个数组的顺序，越乱越好
 */
public class OutCode {
    public static void main(String[] args) {
        int a[] = new int[100];
        for(int i=0; i< 100; i++){
            a[i] = i;
        }
        Random random = new Random();
        int highBound = 99, tmpIndex;
        while (highBound >= 1){
            tmpIndex = random.nextInt(1000) % highBound;
            swap(tmpIndex,highBound,a);
            highBound--;
        }

        for (int i=0; i< 100; i++){
            System.out.print(a[i] + ",");
        }

    }

    /**
     * 交换数字
     * @param a
     */
    private static  void swap(int i, int j, int[] a){
        if(i == j){
            return;
        }

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}