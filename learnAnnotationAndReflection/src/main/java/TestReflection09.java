import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @className: TestReflection09
 * @Description: 通过反射获取注解信息并实现ORM的映射功能
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/29 20:35
 */
public class TestReflection09 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> employee = Class.forName("Employee");
        //获取所有的注解
        Annotation[] annotations = employee.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //输出之后发现只能获取到类上的保留到 RUNTIME时期的注解
        // 其他retention状态的注解由于在编译之后就没有了，代码在执行的之后自然就获取不到

        //知道所有的注解之后我们可以获取指定注解
        //获取指定注解
        TableEmp annotation = employee.getAnnotation(TableEmp.class);
        String value = annotation.value();
        //获取指定注解的值
        System.out.println(value);


        //获取field上的注解的值
        Field declaredField = employee.getDeclaredField("name");
        Annotation[] declaredAnnotations = declaredField.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }

        //获取指定的注解
        FieldEmpl annotation1 = declaredField.getDeclaredAnnotation(FieldEmpl.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.length());
        System.out.println(annotation1.type());

    }
}

//映射student表
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableEmp("t_employee") //给出数据库表名
class Employee {
    @FieldEmpl(columnName = "id", type = "int", length = 8)
    private int id;

    @FieldEmpl(columnName = "name", type = "varchar",length = 32)
    private String name;
    @FieldEmpl(columnName = "age",type = "int",length = 8)
    private int age;
}

//自定义注解
//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableEmp {
    //表名
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldEmpl {
    String columnName();
    String type();
    int length();
}

/*
想要获取注解信息，有以下几个步骤：
 1. 获取到 Class对象
 2.1.1 如果只想获取类上的注解、那么就可以使用getDeclaredAnnotation(注解的类对象)
 2.2.1 如果要获取field、method上的注解，那么就先通过类对象获取field/method，本程序获取field
 2.3 获取到field之后，在通过field对象使用getDeclaredAnnotation(注解类的对象)方法来获取annotation
 2.4 获取到annotation之后，使用其value()方法

 注意：getDeclaredAnnotations()方法获取到的是注解数组，通过数组可以查看到注解的名称，但是无法具体获取到注解的某个值
      我们可以通过这个方法来获得注解名，然后就在getDeclaredAnnotation()中参数填写 注解名.class  即可获取想要的注解中的值
*/