/**
 * @className: TestThread09_testJoin
 * @Description: 理解join方法
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/19 11:43
 */
/*
当两个线程都在等待CPU调度的时候，join方法的作用是强制执行该线程，让其他线程处于阻塞状态

使用了join可以理解成插队，谁使用了join谁就是VIP，先执行它的业务

*/
public class TestThread09_testJoin {
    public static void main(String[] args) throws InterruptedException {
        MyJoin myJoin = new MyJoin();
        Thread thread = new Thread(myJoin);
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("我是普通用户"+i);
            if (i == 50)
            thread.join();
        }
    }
}

class MyJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("vip来了" + i);
        }

    }
}
