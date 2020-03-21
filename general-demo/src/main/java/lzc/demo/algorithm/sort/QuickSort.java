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
		System.out.println("请输入：");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];

		System.out.println("输入顺序为：");
		for(int i =0 ; i <n; i++){
			a[i] = sc.nextInt();
			System.out.print(a[i] + "  ");
		}

		quickSort(a,0,n-1);

		System.out.println("排序后的顺序为：");
		for(int i =0 ; i <n; i++){
			System.out.print(a[i] + "  ");
		}

	}

	private static void quickSort(int[] a, int left, int right){
		int i, j, t, temp;
		if(left>right){
			return;
		}

		temp = a[left];
		i = left;
		j = right;
		while (i != j){
			//从右端找第一个小于temp的下标
			while (a[j] >= temp && i<j){
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

		quickSort(a,left,i-1);
		quickSort(a,i+1, right);
	}
}
