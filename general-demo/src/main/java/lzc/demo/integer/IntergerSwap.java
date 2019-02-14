package lzc.demo.integer;

import java.lang.reflect.Field;

/**
 * Created by liuzc on 2019/2/14.
 */
public class IntergerSwap {
    public static void main(String[] args) {
        Integer a = 1,b =2;
        System.out.println("before swap a=" + a + "  b=" + b);
        try {
            swap(a,b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("after swap a=" + a + "  b=" + b);
    }

    /**
     * 考察的知识点
     * <ul>
     *     <li>1.函数传参是基本类型时，参数是原始值的副本；当传参是引用类型时，传递的是引用地址</li>
     *     <li>2. 反射</li>
     *     <li>3. Integer -128到127的整型会被缓存 </li>
     *     <li>4.自动装箱、拆箱</li>
     * </ul>
     * @param i1
     * @param i2
     */
    private static void swap(Integer i1, Integer i2) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);

        Integer tmp = new Integer(i1.intValue());
        field.set(i1,i2.intValue());
        field.set(i2,tmp);
    }
}
