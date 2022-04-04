import com.asher.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @className: TestReflection06
 * @Description: 通过反射操作一个类中的属性、方法
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/27 17:42
 */
public class TestReflection06 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //先提出问题：newInstance方法得到的类的实例不能直接调用方法吗？ 或者说newInstance得到的是Class对象还是class实例
        Class<?> c1 = Class.forName("com.asher.User");
        Constructor<?> userConstructor = c1.getDeclaredConstructor();
        User userInstance = (User) userConstructor.newInstance();
        userInstance.setAge(12);
        System.out.println(userInstance.getAge());
        User u2 = (User) c1.getDeclaredConstructor().newInstance();
        System.out.println(u2.hashCode() + "\n" + userInstance.hashCode());
    }
}
