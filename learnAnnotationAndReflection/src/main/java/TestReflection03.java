/**
 * @className: TestReflection03
 * @Description: 测试什么时候类会被加载
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/26 16:04
 */
public class TestReflection03 {
    static  {
        System.out.println("The class TestReflection03 what main method locate in is loaded");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //new出子类Son，父类也会被加载
        //Son son = new Son();

        //Class.forName("Son");

        //System.out.println(Son.father);//子类不会被加载

        System.out.println(Son.M); //引用常量不会加载类

        Son[] sons = new Son[10];   //定义类的数组引用不会加载类


    }
}

class Father {
    static int father = 100;

    static  {
        System.out.println("class Father loaded");
    }
}

class Son extends Father {
    static int son = 200;

    static  {
        System.out.println("class son loaded");
        son = 300;
    }

    static final int M = 999; //常量
}

/*
 * 主动引用类时类会被加载
 *  主动引用有哪些：1. new的方式   2. 通过reflection的方式  3. 主动引用子类的时候会引起父类加载     4. main方法所在
 *               类自动被加载
 * 被动引用类的类不会被加载
 *  被动引用有哪些：1. 调用类中的常量（被final修饰的变量）    2. 子类调用父类的static对象不会引起子类被加载：因为只有真正
 *               声明了这个静态域的类才会被加载    3. 数组定义的类引用不会加载类：只会定义出一片空间
 *
 * 注意：被加载的是属于类的数据，所以一般是static修饰的语句
 * @return
*/