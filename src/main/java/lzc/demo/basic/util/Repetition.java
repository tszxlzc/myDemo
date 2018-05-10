package lzc.demo.basic.util;

/**
 * 比较两个字符串重复的算法,相关说明可参见@see <a href="https://blog.csdn.net/znb769525443/article/details/52582888">csdn博客</a>
 *
 * @author liuzongchang
 * @create 2018-05-10 10:33
 **/
public class Repetition
{
	private int compare(String str, String target)
	{
		int d[][];              // 矩阵
		int n = str.length();
		int m = target.length();
		int i;                  // 遍历str的
		int j;                  // 遍历target的
		char ch1;               // str的
		char ch2;               // target的
		int temp;               // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
		if (n == 0) { return m; }
		if (m == 0) { return n; }
		d = new int[n + 1 ][m + 1];
		for (i = 0; i <= n; i++)
		{                       // 初始化第一列
			d[i][0] = i;
			System.out.println(d[i][0]);
		}

		for (j = 0; j <= m; j++)
		{                       // 初始化第一行
			d[0][j] = j;
			System.out.println(d[0][j]);
		}

		for (i = 1; i <= n; i++)
		{                       // 遍历str
			ch1 = str.charAt(i - 1);
			// 去匹配target
			for (j = 1; j <= m; j++)
			{
				ch2 = target.charAt(j - 1);
				if (ch1 == ch2 || ch1 == ch2+32 || ch1+32 == ch2)
				{
					temp = 0;
				} else
				{
					temp = 1;
				}
				// 左边+1,上边+1, 左上角+temp取最小
				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
			}
		}

		for(i = 0; i <= n; i++){
			for(j=0; j<=m; j++){
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
		return d[n][m];
	}

	private int min(int one, int two, int three)
	{
		return (one = one < two ? one : two) < three ? one : three;
	}

	/**
	 * 获取两字符串的相似度
	 */

	public float getSimilarityRatio(String str, String target)
	{
		return 1 - (float) compare(str, target) / Math.max(str.length(), target.length());
	}

	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		Repetition lt = new Repetition();
		String str = "hello";
		String target = "hello";
		System.out.println("similarityRatio=" + lt.getSimilarityRatio(str, target)*100+"%");
		long end = System.currentTimeMillis();

		System.out.println(end -start);
	}
}