package lzc.demo.classloaderSequence;

/**
 * Created by liuzc on 2019/1/6.
 */
public class SingletonDemo {
    private static SingletonDemo singleton = new SingletonDemo();
    private static int count1;
    private static int count2=0;

    private SingletonDemo(){
        count1++ ;
        count2++;
    }

    private static SingletonDemo getSingleton(){
        return singleton;
    }

    public static void main(String[] args) {
        SingletonDemo.getSingleton();
        System.out.println("count1=" + count1);
        System.out.println("count2=" + count2);

        /*
        输出结果如下：
        count1=1
        count2=0

        说明成员变量是按顺序初始化的， private static SingletonDemo singleton = new SingletonDemo();
        执行之后，count1=1 count2=1
        后来count2又初始化为0了
         */
    }
}
