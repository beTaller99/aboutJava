import java.util.ArrayList;

/**
 * @className: TestThread11_unsafeThread02
 * @Description: 通过本程序展示集合ArrayList为什么是线程不安全的
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/20 11:13
 */
public class TestThread11_unsafeThread02 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread( () -> {
               arrayList.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(arrayList.size());
    }
}

/*
 * 1.当我们想要一个新的线程对象使用类中的对象的时候可以使用lambda表达式（作为匿名类的简化）访问到当前方法中的局部变量类
 *  2.ArrayList的size始终无法达到1000，是因为多个线程看到的是list中的同一个位置，后一个线程把前一个线程写入的元素给覆盖了
 */