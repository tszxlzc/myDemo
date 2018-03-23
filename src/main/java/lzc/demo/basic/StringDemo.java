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
		System.out.println(str1 == "abc");
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
		System.out.println(str2 == "abc");
	}
}
