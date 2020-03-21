package lzc.demo.algorithm.sort;

/**
 * 插入排序算法
 */
public class InsertSort {
    public static void main(String[] args) {
        int array[] = {7,3,19,40,4,7,1};
        insertSort(array);

        for(int i=0; i< array.length; i++){
            System.out.print(array[i] + "  ");
        }
    }

    /**
     * 算法原理：
     *  对于给定的一组记录，初始时候假设第一个记录自成一个有序序列，其余记录为无序序列。
     *  接着从第二个记录开始，按照记录大小依次将当前的记录插入到其之前的 有序序列中，
     *  直至最后一个记录插入到有序序列为止。
     * @param a
     */
    public static void insertSort(int[] a){
        if(a != null){
            // i=1 假设第一个记录自成序列
            for(int i=1; i<a.length;i++){
                int temp=a[i], j= i;

                // temp即为下一个无序记录，temp依次和之前有序序列进行比较
                if(a[j-1] > temp){
                    while (j>=1 && a[j-1]> temp){
                        // 移动有序序列
                        a[j]=a[j-1];
                        j--;
                    }
                }

                // 将temp 插入到有序序列
                a[j] = temp;
            }
        }
    }
}