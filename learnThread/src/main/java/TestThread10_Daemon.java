/**
 * @className: TestThread10_Daemon
 * @Description: 验证：jvm不会等待守护线程执行结束才停止，而是用户线程停止之后jvm就会停止
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/19 16:55
 */
public class TestThread10_Daemon {
    public static void main(String[] args) {
        Family family = new Family();
        Thread thread = new Thread(family);
        thread.setDaemon(true);

        thread.start();

        new Thread(new You()).start();
    }
}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("you are alive");
        }
        System.out.println("================== goodbye world! ===================");
    }
}

class Family implements Runnable {

    @Override
    public void run() {
        //循环true，永远不会停止运行，除非虚拟机停止了
        while (true) {
            System.out.println("family protect you");
        }
    }
}

//守护线程可以用来做 日志记录 监控内存 垃圾回收
//虚拟机会确保用户线程执行完毕之后在关闭