/**
 * @className: TestThread02
 * @Description: create a Thread by (@code implements Runnable) implementing Runnable
 * @version: v17
 * @author: asher
 * @date: 2022/3/15 12:31
 */
public class TestThread02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("the value of i in " + Thread.currentThread().getName() + " Thread is" +
                    i);
        }
    }

    public static void main(String[] args) {
        TestThread02 testThread02 = new TestThread02();
        new Thread(testThread02,"实现Runnable接口的线程").start();
        for (int i = 0; i < 500; i++) {
            System.out.println("the value of i in main Thread is" + i);
        }
    }
}
