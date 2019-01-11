package lzc.demo.clone.deep.stream;


import java.io.*;

/**
 * Created by liuzc on 2019/1/11.
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -1947729278344940671L;
    private String name;

    private int age;

    private Professor professor;

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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", professor="
                + professor + "]";
    }

    public Object clone() throws CloneNotSupportedException{
        ByteArrayOutputStream bo=null;
        ObjectOutputStream oo=null;
        ByteArrayInputStream bi=null;
        ObjectInputStream oi=null;
        Object object=null;
        try {
            bo=new ByteArrayOutputStream();
            oo=new ObjectOutputStream(bo);
            oo.writeObject(this);
            bi=new ByteArrayInputStream(bo.toByteArray());
            oi=new ObjectInputStream(bi);
            object=oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
