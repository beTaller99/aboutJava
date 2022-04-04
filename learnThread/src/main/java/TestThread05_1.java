/**
 * @className: TestThread05_1
 * @Description: 学习多线程中设计的  lambda表达式   静态代理内容
 * 当我们有一个接口，要获得一个接口对象之前，一般要有一个类来实现这个接口，从实现的复杂程度（繁-》简）来说分别是：普通实现类-》
 * 静态内部类--》局部内部类 --》 匿名内部类 --》lambda表达式
 * 在学习lambda表达式之前我们还要  函数式接口：接口中只有一个方法（除父类方法外）
 * @version: v17
 * @author: asher
 * @date: 2022/3/17 20:33
 */
public class TestThread05_1 {

    //2.静态 成员内部类
    //显然静态内部类写的位置必普通内部类方便
    static class StaImpl implements TestLambda{

        @Override
        public void sayYes() {
            System.out.println("yes in StaImpl");
        }
    }

    public static void main(String[] args) {
        //我们使用接口对象的时候就可以直接指向new出来的实现类
        TestLambda testLambda = null;

        //调用普通实现类对象的方法
        testLambda = new NomalImpl();
        testLambda.sayYes();

        //调用静态实现类对象的方法
        testLambda = new StaImpl();
        testLambda.sayYes();

        //局部实现类
        class LocalImpl implements TestLambda {
            @Override
            public void sayYes() {
                System.out.println("yes in LocalImpl");
            }
        }

        //调用局部实现类对象的方法
        testLambda = new LocalImpl();
        testLambda.sayYes();

        //匿名内部类
        //匿名内部类就是new出一个接口对象，注意：是 接口对象，不是实现类对象
        testLambda = new TestLambda() {
            @Override
            public void sayYes() {
                System.out.println("yes in AnonymousImplClass");
            }
        };

        //调用匿名类对象的方法
        testLambda.sayYes();

        //lambda表达式
        testLambda = () -> System.out.println("yes in lambda");
        //仔细观察lambda表达式可以发现，lambda就是在匿名内部类的基础上去掉了 接口名并且加上了 ->
        //因为能用lambda表达式都是函数式接口，只有一个方法，那么就不需要接口名，只需要关注这个方法的参数以及方法内容即可

        testLambda.sayYes();

    }

}

interface TestLambda {
 void sayYes();
}

//1.普通实现类
class NomalImpl implements TestLambda{

    @Override
    public void sayYes() {
        System.out.println("yes in NomalImpl");
    }
}