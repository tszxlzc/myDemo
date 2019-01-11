package lzc.demo.proxy;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by liuzc on 2018/12/30.
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Dymicproxy dymicproxy = new Dymicproxy();
        Payment payment = new ALiPayment();
        Payment p1 = (Payment) dymicproxy.bind(payment);
        System.out.println("支付宝支付的结果" + p1.doPay("lzc"));

        Payment wxPayment = new WXPayment();
        Payment p2 = (Payment) dymicproxy.bind(wxPayment);
        System.out.println("微信支付的结果为：" + p2.doPay("liuzc"));

        //下面代码在将生成的代理类class文件输出
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0",ALiPayment.class.getInterfaces());
        String path = "PaymentProxy.class";
        try (FileOutputStream fos = new FileOutputStream(path)){
            fos.write(classFile);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
