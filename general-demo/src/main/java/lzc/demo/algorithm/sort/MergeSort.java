package lzc.demo.algorithm.sort;

/**
 * 归并排序
 * 原理如下：
 * 对于给定的一组记录（假设共有n个记录），首先将两个相邻的长度为1的子序列及进行归并，
 * 得到n/2(向上取整)个长度为2或为1的有序子序列，再将其两两归并，反复执行执行此过程，直到得到一个有序序列
 *
 * 归并排序的关键就是两步：
 * 第一步，划分半子表；
 * 第二步，合并半子表
 */
public class MergeSort {
    public static void main(String[] args) {
        int a[] = {5,4,9,7,8,6,0,1,3,2};
        mergeSort(a,0,a.length-1);

        for (int i =0; i< a.length;i++){
            System.out.print(a[i] + "  ");
        }
    }

    /**
     *
     * @param array
     * @param p  半子表的最小下标
     * @param r  半子表的最大下标
     */
    public static void mergeSort(int array[], int p, int r){
        if(p<r){
            // 表中间下标
            int q = (p+ r)/2;
            // 第一步，划分半子表；
            //左半表
            mergeSort(array,p,q);
            //右半表
            mergeSort(array,q+1,r);
            //第二步，合并半子表
            merge(array,p,q,r);
        }

    }

    /**
     * 第二步，合并半子表
     * @param array
     * @param p 左半表最小下标
     * @param q  表中间下标
     * @param r 右半表最大小标
     */
    public static void merge(int array[], int p, int q, int r){
        int i,j,k,n1,n2;
        //左半表的大小
        n1 = q-p+1;
        //右半表的大小
        n2 = r-q;
        //临时存放左半表的数据
        int[] L = new int[n1];
        //临时存放右半表的数据
        int[] R = new int[n2];
        //将array中的数据放到临时左半表
        for (i=0, k = p;i<n1;i++,k++){
            L[i] = array[k];
        }
        //将array中的数据放到临时左半表
        for (i=0,k=q+1;i<n2;i++,k++){
            R[i] = array[k];
        }

        // 半表合并
        for (k=p,i=0,j=0; i<n1 && j<n2; k++){
            // 从临时左右半表中，找不较大的赋值给array[k]
            if(L[i]>R[j]){
                array[k] = L[i];
                i++;
            }else {
                array[k] = R[j];
                j++;
            }
        }

        // 临时左半表中剩余的数据进行合并
        if(i<n1){
            for (;i<n1;i++,k++){
                array[k] = L[i];
            }
        }

        // 临时右半表中剩余的数据进行合并
        if(j<n2){
            for (;j<n2; j++, k++){
                array[k] = R[j];
            }
        }
    }


}