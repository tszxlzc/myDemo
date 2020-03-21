package lzc.demo.algorithm.sort;

import java.util.Scanner;

/**
 * 快速排序
 * <a href="http://developer.51cto.com/art/201403/430986.htm#topx"> 参考博客链接</a>
 * @author liuzongchang
 * @create 2018-06-12 15:36
 **/
public class QuickSort {

	public static void main(String[] args){
//		System.out.println("请输入：");
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] a = new int[n];

//		System.out.println("输入顺序为：");
//		for(int i =0 ; i <n; i++){
//			a[i] = sc.nextInt();
//			System.out.print(a[i] + "  ");
//		}

		int n = 10;
		int[] a ={5,4,9,7,8,6,0,1,31,2};
		quickSort(a,0,n-1);

		System.out.println("排序后的顺序为：");
		for(int i =0 ; i <n; i++){
			System.out.print(a[i] + "  ");
		}

	}

	/**
	 * 快速排序是一种非常高效的排序算法，它采用“分而治之”的思想，把大的拆分为小的，
	 * 小的再拆分为更小的。
	 *
	 * 快速排序原理如下：
	 * 对于一组给定的记录，通过一趟排序后，将原序列分为两部分，
	 * 其中前一部分的所有记录均比后一部分的所有记录小，然后再依次对前后两部分的记录进行快速排序，
	 * 递归该过程，直到序列中的所有记录均有序为止。
	 * @param a
	 * @param left
	 * @param right
	 */
	private static void quickSort(int[] a, int left, int right){
		int i, j, t, temp;
		if(left>right){
			return;
		}

		temp = a[left];
		i = left;
		j = right;
		while (i < j){
			//从右端找第一个小于temp的下标
			while (i<j && a[j] >= temp){
				j--;
			}
			//从左端找第一个大于temp的下标
			while (a[i]<=temp && i<j){
				i++;
			}
			//左端第一个大于temp的值和右端第一个小于temp的值互换
			if(i<j){
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}

		//最终将基数归位
		a[left] = a[i];
		a[i] = temp;

		// i做为比较基准已经比较过了，就在左右两半的中间，所以下标为i的 元素不用再参与排序了
		quickSort(a,left,i-1);
		quickSort(a,i+1, right);
	}
}
