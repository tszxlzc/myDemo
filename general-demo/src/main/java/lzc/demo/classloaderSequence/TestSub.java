package lzc.demo.classloaderSequence;

/**
 * Created by liuzc on 2019/1/6.
 */
public class TestSub extends Test {

    static Sample samplesub = new Sample("TestSub的静态对象初始化"); //4

    public TestSub(){
        System.out.println("TestSub默认构造方法被调用");
    }

    Sample sample = new Sample("TestSub类的普通成员变量初始化");

    static {
        System.out.println("TestSub静态块初始化"); //5
    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
