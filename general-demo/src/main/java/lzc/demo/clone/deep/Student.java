package lzc.demo.clone.deep;

/**
 * Created by liuzc on 2019/1/11.
 */
//必须要实现cloneable接口
public class Student implements Cloneable {

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
        Student student = (Student) super.clone();
        student.setProfessor((Professor) professor.clone());
        return student;
    }

}
