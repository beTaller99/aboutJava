import lombok.Data;

/**
 * @className: TestReflection01
 * @Description: 学习创建Class对象的几种方式
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/25 21:33
 */
public class TestReflection01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //第一种方式：使用对象的getClass方法
        Person person = new Student("学生");
        Class<? extends Person> c1 = person.getClass();
        System.out.println(c1.hashCode()); //查看Class对象的hashCode

        //第二种方式：反射，通过全类名的方式
        Class<?> aClass = Class.forName("Student");
        System.out.println(aClass.hashCode());

        //第三种方式：通过 类名.class 获取
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass.hashCode());

        //三种方式得到的Class对象输出的hashCode都是一样的，因为类加载时在内存中只创建一个对象

        Class<?> superclass = c1.getSuperclass();
        System.out.println(superclass);
    }
}
@Data
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

}

class Student extends Person {
    public Student(String name) {
        super(name);
    }

}

class Teacher extends Person {

    public Teacher(String name) {
        super(name);
    }
}