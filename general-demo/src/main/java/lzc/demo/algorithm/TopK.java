package lzc.demo.algorithm;

import lzc.demo.algorithm.sort.MinHeapSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 建堆的时间复杂度O(mlogm)  m为top的数组大小
 * topK的算法复杂度为O(nmlogm) n为总样本数
 *
 * 题目类型如下：
 * 1. 找出1亿个随机数中最大的10个
 * 2. 找出双十一支付金额最多的用户
 * 3. 找出所有商品里评分最高的商品
 * 等等
 */
public class TopK {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>(10000000);
        for(int i=0; i < 10000000; i++){
            arrayList.add(i);
        }
        //打乱顺序
        Collections.shuffle(arrayList);

        //取出top10
        int top10[] = new int[10];
        for (int i = 0; i < arrayList.subList(0, 10).size(); i++) {
            top10[i] = arrayList.get(i);
        }

        // 先进行一次排序
        MinHeapSort.myMinHeapSort(top10);

       for (int i=top10.length; i< arrayList.size(); i++){
           if(top10[top10.length -1 ] < arrayList.get(i)){
               top10[top10.length -1] = arrayList.get(i);
               // 新的元素加进来，重新堆排序
               MinHeapSort.myMinHeapSort(top10);
           }
       }

       long end = System.currentTimeMillis();
       System.out.println("耗时数" + (end -start));

       for (int i=0; i< top10.length; i++){
           System.out.print(top10[i] + "  ");
       }


    }
}