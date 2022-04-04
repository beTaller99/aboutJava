/**
 * @className: TestThread07
 * @Description: 实现线程停止的一般方法
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/19 11:08
 */

/*
线程有五个状态  new 就绪状态 运行状态 阻塞状态 terminate 线程停止一般是从运行态到达terminate
*/
public class TestThread07 implements Runnable{
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "-->" +  i++);
        }
    }

    public void termina() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestThread07 testThread07 = new TestThread07();
        for (int i = 0; i < 500; i++) {

            new Thread(testThread07).start();

            System.out.println(Thread.currentThread().getName() + "-->" + i);
            testThread07.termina();
        }
    }
}
