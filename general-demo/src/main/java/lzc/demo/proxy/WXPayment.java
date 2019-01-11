package lzc.demo.proxy;

/**
 * Created by liuzc on 2019/1/11.
 */
public class WXPayment implements Payment{
    @Override
    public String doPay(String uid) {
        System.out.println("uid为：" + uid +"的用户正在使用微信支付");
        return "success";
    }
}
