package lzc.demo.basic;

/**
 * String类测试demo
 *
 * @author liuzongchang
 * @create 2018-03-23 11:04
 **/
public class StringDemo {
	public static void main(String[] args){
		method1();
		method2();
		method3();
		method4();
		method5();
		method6();
		method7();
		method8();
		method9();
	}


	/**
	 *  1) 栈中开辟一块空间存放引用str1；
	 * 2) String池中开辟一块空间，存放String常量"abc"；
	 * 3) 引用str1指向池中String常量"abc"；
	 * 4) str1所指代的地址即常量"abc"所在地址，输出为true；
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 11:11
	 */
	public static void method1(){
		String str1 = "abc";
		System.out.println("method1的结果:" + (str1 == "abc"));
	}

	/**
	 *  1) 栈中开辟一块空间存放引用str2；
	 * 2) 堆中开辟一块空间存放一个新建的String对象"abc"；
	 * 3) 引用str2指向堆中的新建的String对象"abc"；
	 * 4) str2所指代的对象地址为堆中地址，而常量"abc"地址在池中，输出为false；
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 11:14
	 */
	public static void method2(){
		String str2 = new String("abc");
		System.out.println("method2的结果:" + (str2 == "abc"));
	}

	/**
	 *  1) 栈中开辟一块空间存放引用str3；
	 *  2) 堆中开辟一块新空间存放另外一个(不同于str2所指)新建的String对象；
	 *  3) 引用str3指向另外新建的那个String对象 ；
	 *  4) str3和str2指向堆中不同的String对象，地址也不相同，输出为false；
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 11:53
	 */
	public static void method3(){
		String str2 = new String("abc");
		String str3 = new String("abc");
		System.out.println("method3的结果:" + (str3 == str2));
	}

	/**
	 * 1) 栈中开辟一块空间存放引用str4；
	 * 2) 根据编译器合并已知量的优化功能，池中开辟一块空间，存放合并后的String常量"ab"；
	 * 3) 引用str4指向池中常量"ab"；
	 * 4) str4所指即池中常量"ab"，输出为true；
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 11:54
	 */
	public static void method4(){
		String str4 = "a" + "b";
		System.out.println("method4的结果:" + (str4 == "ab"));
	}

	/**
	 * 1)栈中开辟一块空间存放引用str5；
	 * 2) 根据编译器合并已知量的优化功能，池中开辟一块空间，存放合并后的String常量"ab"；
	 * 3) 引用str5指向池中常量"ab"；
	 * 4) str5所指即池中常量"ab"，输出为true；
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 11:56
	 */
	private static void method5(){
		//注意:这里s用final修饰，相当于一个常量
		final String s = "a";
		String str5 = s + "b";
		System.out.println("method5的结果:" + (str5 == "ab"));
	}

	/**
	 * 1) 栈中开辟一块中间存放引用s1，s1指向池中String常量"a"，
	 * 2) 栈中开辟一块中间存放引用s2，s2指向池中String常量"b"，
	 * 3) 栈中开辟一块中间存放引用str6，
	 * 4) s1 + s2通过StringBuilder的最后一步toString()方法还原一个新的String对象"ab"，因此堆中开辟一块空间存放此对象，
	 * 5) 引用str6指向堆中(s1 + s2)所还原的新String对象，
	 * 6) str6指向的对象在堆中，而常量"ab"在池中，输出为false
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 12:00
	 */
	private static void method6(){
		String s1 = "a";
		String s2 = "b";
		String str6 = s1 + s2;
		System.out.println("method6的结果:" + (str6 == "ab"));
	}

	/**
	 * 1) 栈中开辟一块空间存放引用str7，
	 * 2) substring()方法还原一个新的String对象"ab"（不同于str6所指），堆中开辟一块空间存放此对象，
	 * 3) 引用str7指向堆中的新String对象
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 14:42
	 */
	private static void method7(){
		String s1 = "a";
		String s2 = "b";
		String str6 = s1 + s2;
		String str7 = "abc".substring(0, 2);
		System.out.println("method7的结果:" + (str6 == str7));
	}

	/**
	 * 1) 栈中开辟一块空间存放引用str6，
	 * 2) toUpperCase()方法还原一个新的String对象"ABC"，池中并未开辟新的空间存放String常量"ABC"，
	 * 3) 引用str8指向堆中的新String对象
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 15:21
	 */
	private static void method8(){
		String str8 = "abc".toUpperCase();
		System.out.println("method8的结果:" + (str8== "abc"));
	}
	
	/**
	 * 1）栈中开辟一块空间存放s；
	 * 2）Sting池中开辟一块空间用于存放"abc"，栈中开辟一块空间存放变量s1；
	 * 3）系统输出true，在堆中开辟一块空间用于存放"abchello"；
	 * 4）引用s指向堆中的"abchello"；
	 * 5）系统输出true，然后输出false；
	 * @return
	 * @author liuzongchang
	 * @date 2018/3/23 15:25
	 */
	private static void method9(){
		String s="abc";
		String s1=s;
		System.out.println(s1=="abc");

		s=s+"hello";
		System.out.println(s1=="abc");
		System.out.println(s=="abc");
	}
}
