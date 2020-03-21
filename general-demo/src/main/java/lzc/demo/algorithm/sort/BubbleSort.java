package lzc.demo.algorithm.sort;

/**
 * 冒泡排序
 * <p></p>
 *  <a href = "https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">演示地址</a>
 * @author liuzongchang
 * @create 2018-06-12 14:29
 **/
public class BubbleSort {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 4, 2, 5 , 10 ,6,11,30,2,0};
		//冒泡排序
		//length-1 次遍历
		for (int i = 0; i < a.length - 1; i++) {
			// 最大值往上冒到 a.length -1 - i 的位置
			for(int j=0;j < a.length -1 - i;j++){
				if(a[j] > a[j+1]){
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}


		//输出排序结果
		for(int i= 0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}
}
