import com.asher.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @className: TestReflection07
 * @Description: 测试反射方式使用访问类的方法的性能
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/28 20:16
 */
public class TestReflection07 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    test01();
    test02();test03();
    }

    static void test01() {
        //正常方式获取类对象
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < 1000000000l; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("正常方式调用类方法所使用的时间：" + (endTime - startTime) + "ms");

    }

    static void test02() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //反射方式性能测试
        User user = new User();
        Class<? extends User> userClass = user.getClass();
        Method getName = userClass.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < 1000000000l; i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("正常方式调用类方法所使用的时间：" + (endTime - startTime) + "ms");

    }

    static void test03() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //反射，关闭检测，性能分析
        User user = new User();

        Class<? extends User> userClass = user.getClass();
        Method getName = userClass.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < 1000000000l; i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("正常方式调用类方法所使用的时间：" + (endTime - startTime) + "ms");

    }
}
