/**
 * @className: TestReflection02
 * @Description: 理解代码从方法区到堆区到栈区的加载过程，每一步发生了什么
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/26 15:46
 */
public class TestReflection02 {
    public static void main(String[] args) {
        Load load = new
                Load();

        System.out.println(load.i);
    }
}

class Load {

    static {
        System.out.println("start load static sentences");
        i = 66;
    }
    static int i = 55;
    public Load() {
        System.out.println("init object A ");
    }
}

/*
类的成员变量、static变量、方法加载到  方法区 --》 在堆中生成对应的Class对象  --》 在栈区对变量初始化为0 --》 jvm加载对象，
按顺序执行语句，然后i就被赋值为55
 * @return
*/