package lzc.demo.clone.deep.stream;

import java.io.Serializable;

/**
 * Created by liuzc on 2019/1/11.
 */
public class Professor implements Serializable{

    private static final long serialVersionUID = -9173135915970351401L;
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Professor [name=" + name + ", age=" + age + "]";
    }

}