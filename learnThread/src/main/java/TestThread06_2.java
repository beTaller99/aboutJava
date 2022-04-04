/**
 * @className: TestThread06_2
 * @Description: 在多线程中利用静态代理与lambda表达式
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/18 14:31
 */
public class TestThread06_2 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("通过lambda表达式替代了我们自己手动实现Runnable接口的类从而实现了静态代理");
        }).start();
    }
}
