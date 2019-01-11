package lzc.demo.clone.shadow;

/**
 * Created by liuzc on 2019/1/11.
 * 潜克隆
 */
public class ShadowCopy {

    public static void main(String[] args) {
        Professor p1 = new Professor();
        p1.setName("Professor Zhang");
        p1.setAge(30);

        Student s1 = new Student();
        s1.setName("xiao ming");
        s1.setAge(18);
        s1.setProfessor(p1);

        System.out.println(s1);

        try {
            Student s2 = (Student) s1.clone();
            //这里是想说这个同学有两个教授给她上课，结果却没有成功
            Professor p2 = s2.getProfessor();
            p2.setName("Professor Li");
            p2.setAge(45);
            s2.setProfessor(p2);
            System.out.println("复制后的：s1 = " + s1);
            System.out.println("复制后的：s2 = " + s2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}