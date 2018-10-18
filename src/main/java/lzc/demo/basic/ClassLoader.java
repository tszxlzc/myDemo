package lzc.demo.basic;

/**
 * 类加载顺序测试
 *
 * @author liuzongchang
 * @create 2018-06-20 15:13
 **/
public class ClassLoader {
	public static void main(String[] args){
		A ab = new B();
		ab = new B();
	}
}
class A{
	static {
		System.out.print("1");
	}

	public A() {
		System.out.print("2");
	}
}

class B extends A{
	static {
		System.out.print("a");
	}

	public B() {
		System.out.print("b");
	}
}
