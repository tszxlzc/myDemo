package lzc.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liuzc on 2018/12/30.
 */
public class Dymicproxy implements InvocationHandler{

    /**
     * 被代理对象
     */
    private Object target;

    public Object bind(Object object){
        this.target = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理在target执行之前做了一些操作");

        Object object = method.invoke(target,args);

        System.out.println("动态代理在target执行之前做了一些操作");
        return object;
    }
}
