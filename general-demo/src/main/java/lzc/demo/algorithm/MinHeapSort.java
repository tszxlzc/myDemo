package lzc.demo.algorithm;

/**
 * 小顶堆堆排序
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
        int a[] = {5,4,9,8,7,6,0,1,3,2};
        int len = a.length;
        myMinHeapSort(a);
        for (int i =0; i<len; i++){
            System.out.print(a[i] + "  ");
        }
    }

    /**
     * 最小堆
     * @param array
     */
    private static void  myMinHeapSort(int[] array){
        int i;
        int len = array.length;
        // len/2 - 1  父节点的最大位置（比len/2 - 1 位置大的节点都没有子节点）
        // 这里是循环调整所有父节点--即第一次调整整个大堆（父节点及其所有子节点可以看做一个子堆）
        // 从len/2 -1 开始，也就是从最底层的堆开始
        for (i = len/2 -1; i>=0; i--){
            adjustMinHeap(array,i,len-1);
        }

        for (i = len -1; i>=1; i--){
            // 交换堆顶元素和最后一个元素的位置
            int tmp =array[0];
            array[0] = array[i];
            array[i] = tmp;

            // 调整置换后的剩余元素为小顶堆
            adjustMinHeap(array,0,i-1);
        }

    }

    /**
     * 置换后，调整堆
     * @param a 数组
     * @param pos  子堆根节点的位置
     * @param len 为数组最大小标length -1 从后往前推
     */
    private static void adjustMinHeap(int[] a, int pos, int len){
        int temp;
        int child;
        //小顶堆 r(i) <= r(2i+1), i = 1,2,...,n
        for(temp = a[pos]; 2 * pos + 1 <=len; pos = child){
            child = 2 * pos + 1;
            //child 和child + 1 是pos 的两个孩子
            // a[child] > a[child + 1]   即左孩子大于右孩子时，要对右孩子堆调整
            if(child < len && a[child] > a[child + 1]){
                // child ++  等于child + 1 等于 2 * pos + 1 + 1 即父节点的右孩子
                child++;
            }
            // temp = a[pos]  即左孩子小于父节点进行交换
            if(a[child] < temp){
                int swap = a[pos];
                a[pos] = a[child];
                a[child] = swap;
            }else {
                break;
            }
        }
    }


}