package lzc.demo.classloaderSequence;

/**
 * Created by liuzc on 2019/1/6.
 */
public class Sample {
    public Sample() {
        System.out.println("sample 的无参数的构造方法");
    }

    public Sample(String s){
        System.out.println("sample 有参数的构造方法， 参数为：" + s);
    }

}
