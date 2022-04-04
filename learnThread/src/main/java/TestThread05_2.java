/**
 * @className: TestThread05_2
 * @Description: 书接上回，详解lambda表达式的使用注意事项
 * @version: v1.８.0
 * @author: asher
 * @date: 2022/3/17 20:58
 */
public class TestThread05_2 {
    public static void main(String[] args) {
        TestLambda testLambda = null;

        //1.如果方法的实现只有一条语句那么可以不用大括号括起来
        testLambda = () -> System.out.println("say yes 只能一次");
        testLambda.sayYes();

        //2.如果方法的实现不止一条语句，那么所有的语句要用大括号包起来
        testLambda = () -> {
            System.out.println("say yes 一次");
            System.out.println("say yes 两次");
        };
        testLambda.sayYes();

        //3.如果方法有两个或两个以上参数，那么参数类型可写可不写（一般写-》来自Google的codestyle关于lambda的写法），
        // 但是一定要同时都写或都不写，参数要括起来
        TestLambda2 testLambda2 = (a, b) -> {
            System.out.println("你说了--》" + a + " 和"+ b);
        };
        testLambda2.sayYours(520,250);
        //也可以写成
        testLambda2 = (int a, int b) -> {
            System.out.println("你说了--》" + a + " 和"+ b);
        };
        testLambda2.sayYours(250,520);

        //4.只有一个参数时可不用小括号把参数括起来，参数类型可加可不加，加的话要带上小括号
        TestLambda3 testLambda3 = x -> System.out.println("只有一个参数--》" + x);
        testLambda3.sayOneParam(999);
        testLambda3 = (int x) -> System.out.println("只有一个参数且参数类型写出来了：x == " + x);
        testLambda3.sayOneParam(888);
    }
}

interface TestLambda2 {
    void sayYours(int a, int b);
}

interface TestLambda3 {
    void sayOneParam(int x);
}
