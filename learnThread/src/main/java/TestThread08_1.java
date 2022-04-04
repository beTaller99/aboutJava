/**
 * @className: TestThread08_1
 * @Description: 使用线程的sleep方法模拟网络延迟
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/19 11:15
 */
//sleep方法能让线程从运行态转变为阻塞态
public class TestThread08_1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                //模拟网络延迟一秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TestThread08_1()).start();
    }
}
