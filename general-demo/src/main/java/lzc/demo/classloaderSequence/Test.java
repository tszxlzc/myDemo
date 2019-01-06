package lzc.demo.classloaderSequence;

/**
 * Created by liuzc on 2019/1/6.
 */
public class Test {
    static {
        System.out.println("Test的static块1"); //1
    }

    static Sample sample = new Sample("静态成员变量sample初始化"); //2
    Sample sample1 = new Sample("sample1 普通成员变量初始化");

    static {
        System.out.println("Test类的静态块2"); //3
    }

    {
        System.out.println("ordinary method block"); //
    }

    public Test(){
        System.out.println("Test类的无参数构造");
    }

    Sample sample2 = new Sample("sample2 普通成员变量初始化");
}
