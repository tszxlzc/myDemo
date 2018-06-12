package lzc.demo.algorithm;

/**
 * 冒泡排序
 *
 * @author liuzongchang
 * @create 2018-06-12 14:29
 **/
public class BubbleSort {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 4, 2, 5 , 10 ,6,11,30,2,0};
		//冒泡排序
		//length-1 次遍历
		for (int i = 0; i < a.length - 1; i++) {
			//a[i] 跟a[j>=i+1]比较
			for (int j = i+1; j < a.length; j++){
				if(a[i] > a[j]){
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}


		//输出排序结果
		for(int i= 0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}
}
