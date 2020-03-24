package lzc.demo.algorithm.sort;

/**
 *
 *  堆是一个完全二叉树，根节点的值小于（或大于）两个子节点的值
 *
 * 小顶堆堆排序
 *
 * 建堆的时间复杂度O(nlogn)
 *
 * 概念：
 * 小顶堆： r(i) <= r(2i+1), i = 1,2,...,n
 * 大顶堆： r(i) >=r(2i), i =1,2,...,n
 *
 * 堆排序主要包括两个过程：
 * 一是构建；
 * 二是交换堆顶元素与最后一个元素的位置
 * （如果是小顶堆，交换后为从大到小排序；如果是大顶堆，交换后为从小到大排序 ）
 */
public class MinHeapSort {
    public static void main(String[] args) {
        // 可参考lzc.demo.algorithm.OutCode  算法生成随机数
        int a[] = {34,60,75,88,5,65,62,81,69,23,66,24,1,39,89,90,83,53,92,47,54,82,27,49,67,15,93,95,59,84,29,21,16,38,36,18,70,32,61,11,50,8,98,48,13,22,9,78,30,94,72,86,85,26,40,2,58,10,79,96,80,64,57,91,3,99,68,33,37,42,44,19,52,35,63,45,31,14,6,4,0,76,25,41,73,87,28,43,74,51,71,20,77,7,56,46,55,12,97,17};
        int len = a.length;
        myMinHeapSort(a);
        for (int i =0; i<a.length; i++){
            System.out.print(a[i] + "  ");
        }
    }

    /**
     * 最小堆
     * @param array
     */
    public static void  myMinHeapSort(int[] array){
         int len = array.length;
         // len/2 - 1  父节点的最大位置（比len/2 - 1 位置大的节点都没有子节点）
        // 这里是循环调整所有父节点--即第一次调整整个大堆（父节点及其所有子节点可以看做一个子堆）
        // 从len/2 -1 开始，也就是从最底层的堆开始； 也就是对所有子堆进行调整，并且从最底部的len/2 -1个子堆进行调整
         for(int i= len/2 -1; i>=0;i--){
             adjustMinHeap(array,i,len-1);
         }

         for(int i= len-1; i>=1; i--){
             // 交换堆顶元素和最后一个元素的位置
             int swap = array[0];
             array[0] = array[i];
             array[i] = swap;

             //调整置换后的剩余元素为小顶堆
             //前面已经做了交换，所以要 i - 1
             adjustMinHeap(array,0,i-1);
         }



//        int i;
//        int len = array.length;
//        // len/2 - 1  父节点的最大位置（比len/2 - 1 位置大的节点都没有子节点）
//        // 这里是循环调整所有父节点--即第一次调整整个大堆（父节点及其所有子节点可以看做一个子堆）
//        // 从len/2 -1 开始，也就是从最底层的堆开始； 也就是对所有子堆进行调整，并且从最底部的len/2 -1个子堆进行调整
//        for (i = len/2 -1; i>=0; i--){
//            adjustMinHeap(array,i,len-1);
//        }
//
//        for (i = len -1; i>=1; i--){
//            // 交换堆顶元素和最后一个元素的位置
//            int tmp =array[0];
//            array[0] = array[i];
//            array[i] = tmp;
//
//            // 调整置换后的剩余元素为小顶堆
//            adjustMinHeap(array,0,i-1);
//        }

    }

    /**
     * 置换后，构建堆
     * @param a 数组
     * @param rootIndex  堆根节点的位置
     * @param lastIndex  堆最后一个节点的位置
     */
    public static void adjustMinHeap(int[] a, int rootIndex, int lastIndex){
        int child;
        // 小顶堆 r(i) <= r(2i+1), i = 1,2,...,n
        for(;rootIndex * 2 + 1 <= lastIndex; rootIndex = child){
            child = rootIndex * 2 + 1;
            //child 和child + 1 是rootIndex 的两个孩子
            // 选出左右孩子里较小的一个
            if(child < lastIndex && a[child] > a[child + 1]){
                child ++;
            }

            /*
             * 根节点的值小于（或大于）两个子节点的值
             * child 有可能是左孩子也有可能是右孩子; 但由于上面做了判断child < len && a[child] > a[child + 1]，
             * 所以这时候的孩子节点一定是两个孩子节点中最小的值
             *
             * a[pos] > a[child] 成立的话，会进行父节点和最小孩子节点进行交换；
             * 从而满足了根节点的值小于（或大于）两个子节点值的条件
             */
            if(a[rootIndex] > a[child]){
                int swap = a[rootIndex];
                a[rootIndex] = a[child];
                a[child] = swap;
            }else {
                break;
            }
        }
    }


}