import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.*;

/**
 * @className: Test
 * @Description: TODO
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/29 22:44
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> employee = Class.forName("Employee01");
        //获取所有的注解
        Annotation[] annotations = employee.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableEmp("t_employee") //给出数据库表名
    @Tttt
class Employee01 {
    private int id;
    private String name;
    private int age;
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableEmp01 {
    String value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tttt {

}