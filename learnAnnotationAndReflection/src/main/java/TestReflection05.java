import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @className: TestReflection05
 * @Description: 通过本程序展示如何使用反射来获取某个类的所有信息
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/27 17:27
 */
public class TestReflection05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        //类有哪些信息：constructor、field、method
        Class<?> c1 = Class.forName("com.asher.User");

        //获取无参的constructor
        Constructor<?> constructor = c1.getConstructor(null);
        System.out.println(constructor);

        //获取所有的constructor
        Constructor<?>[] constructors = c1.getConstructors();
        for (Constructor<?> constructor1 : constructors) {
            System.out.println(
                    "#" + constructor1
            );
        }

        //获取有参的constructor
        Constructor<?> constructorWithArgs = c1.getConstructor(int.class, String.class, String.class);
        System.out.println(constructorWithArgs);

        /* 来谈谈为什么getConstructor()方法需要参数？  因为 重载，由于有重载，所以我们需要指定参数来让jvm确定我们需要的
            是哪一个构造方法
        * */

        //获取field
        System.out.println("=================获取field===================================");
        //Field name = c1.getField("name"); //报异常，因为name是被private修饰，所以无法被getField获取到
        //System.out.println(name);  //getField()只能访问public修饰的属性

        Field name1 = c1.getDeclaredField("name"); //getDeclareField()方法可以帮助我们访问被private修饰的属性
        System.out.println(name1);

        //获取method
        System.out.println("=================获取method===================================");
        Method setAge = c1.getMethod("setAge", int.class);
        System.out.println(setAge);
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("#" + method); //会返回目标类以及目标类的父类 所有的public修饰的方法，
        }

        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("###" + declaredMethod); //返回目标类的所有方法
        }


        //获取类名
        System.out.println("=============获取类名====================================");
        String name = c1.getName();
        System.out.println(name);
    }
}
