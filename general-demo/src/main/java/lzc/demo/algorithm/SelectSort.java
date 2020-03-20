package lzc.demo.algorithm;

public class SelectSort {
    public static void main(String[] args) {
        int a[] = {5,4,9,8,7,6,0,1,3,2};
        sort(a);

        for(int i =0; i< a.length;i++){
            System.out.print(a[i] + "  ");
        }
    }

    /**
     * 选择排序：
     * 基本原理：对于给定的一组记录，经过第一轮的比较后得到最小的记录，然后与第一个记录的位置进行交换；
     * 接着对不包括第一个记录以外的其他记录进行第二轮比较，得到最小的记录并与第二个记录进行位置交换；
     * 重复该过程，知道进行比较的记录只有一个时为止。
     * @param a
     */
    public static void sort(int[] a){
        int temp;
        int flag = 0;
        for(int i=0;i<a.length;i++){
            temp= a[i];
            flag = i;
            //找i+1 到 a.length -1 的最小值
            for(int j= i +1; j<a.length;j++){
                if(a[j]< temp){
                    temp=a[j];
                    flag = j;
                }
            }

            // flag 和i 位置的下标元素交换
            if(flag != i){
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }
}