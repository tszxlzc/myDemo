package lzc.demo.proxy;

/**
 * Created by liuzc on 2018/12/30.
 */
public class ALiPayment implements Payment {

    @Override
    public String doPay(String uid) {
        System.out.println("正在支付的uid->" + uid);
        return "success";
    }
}
