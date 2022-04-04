/**
 * @className: TestThread08_2
 * @Description: 利用sleep模拟倒计时
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/19 11:24
 */
public class TestThread08_2 implements Runnable{
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Thread(new TestThread08_2()).start();
    }
}
