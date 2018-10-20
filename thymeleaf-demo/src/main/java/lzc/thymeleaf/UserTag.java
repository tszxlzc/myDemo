package lzc.thymeleaf;

import java.lang.annotation.*;

/**
 * Created by liuzc on 2018/10/20.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repeatable(UserTags.class)
public @interface UserTag {

    String id();
}
