import java.util.Properties;

/**
 * @className: TestReflection04
 * @Description: 查看某个类的类加载器+查看总共有哪些类加载器
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/26 21:11
 */
public class TestReflection04 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader(); //获取系统加载器，这是加载用户自定义类的类加载器
        System.out.println(systemClassLoader);

        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        System.out.println(platformClassLoader);

        ClassLoader parent = systemClassLoader.getParent(); //获取SystemLoader的父类加载器
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();  //获取扩展加载器的父类加载器BootStrapLoader，
        //这个类是用来加载核心类的，无法被直接查看， 由于不能直接查看，所以为null
        System.out.println(parent1);

        //查看某个类的类加载器
        //1.获取到这个类的类对象
        //2.使用类对象的获取类加载器方法
        ClassLoader classLoader = TestReflection04.class.getClassLoader();
        System.out.println("当前类使用的类加载器是" + classLoader);

        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println("Object类使用的类加载器是" + classLoader1);

        //查看类加载器 加载类的 路径
        Properties properties = System.getProperties();
        System.out.println(properties);
        //通过类加载器的加载路径我们知道，类加载器去这些路径下把我们需要的类加载到内存中

        /*
        双亲委派机制 ：如果我们自定义得一个类和类加载器的加载路径中的某个类重名（包名和类名都重名）了，那么类加载器就不会加载
        我们自定义的类
         自底向上加载类：BootStrapLoader --》 ExtensionLoade --》 SystemLoader 从父类到子类逐个加载，SystemLoader
         最后加载，所以如果核心类里面已经加载过名称一样的类了就不会再加载我们自定义的类了
        */
    }
}

/*
类加载器有三种，自顶向下依次是：SystemLoader --》extensionLoader --》BootStrapLoader
其中，SystemLoader用来加载用户自定义的类、BootStrapLoader用来加载一些核心类，我们无法直接查看BootStrapLoader，因为
BootStrapLoader使用c/c++写的
*/