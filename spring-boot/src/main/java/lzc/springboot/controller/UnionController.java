package lzc.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("union")
@Slf4j
public class UnionController {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    private Random random = new Random();

    /**
     * 应该有分布式缓存redis 并设置过期时间，由于网络问题，这里先用本地缓存
     */
    private Map<String,Integer> cache = new HashMap<>();

    /**
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "code", method = RequestMethod.POST)
    public String code(String email){
        try {
            valiadateEmail(email);
        }catch (Exception e){
            log.warn("邮箱格式异常",e);
            return "请检查邮箱格式";
        }
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                int code = random.nextInt(999999);
               cache.put(email,code);
                // TODO: 2020/3/27   邮箱发送验证码
            }
        });

        return "验证码已发送";
    }

    @RequestMapping(value = "check", method = RequestMethod.GET)
    public String checkCode(String email,Integer code){
        valiadateEmail(email);

        Integer cacheCode = cache.get(email);
        if(cacheCode != null && cacheCode.equals(code)){
            return "校验成功";
        }else {
            return "验证码错误";
        }
    }



    /**
     * 校验邮箱格式
     * @param email
     */
    private void valiadateEmail(String email){
        Assert.hasText(email,"邮箱地址不能为空");
        // 简单校验邮箱格式，可细化
        Assert.state(email.contains("@"), "校验邮箱格式");
    }

}