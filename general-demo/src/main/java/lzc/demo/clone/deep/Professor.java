package lzc.demo.clone.deep;

/**
 * Created by liuzc on 2019/1/11.
 */
public class Professor implements Cloneable{

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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Professor [name=" + name + ", age=" + age + "]";
    }

}