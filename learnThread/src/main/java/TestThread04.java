/**
 * @className: TestThread04
 * @Description: 利用多线程实现龟兔赛跑
 * @version: v1.８.0
 * @author: asher
 * @date: 2022/3/15 16:37
 */
public class TestThread04 implements Runnable{
    private static String  winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("兔子") && (i & 90) == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //这个让乌龟sleep的语句块是为了让输出的结果更清晰加上去的
            if (Thread.currentThread().getName().equals("乌龟") && (i & 90) == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    boolean gameOver(int i) {
        if (winner != null) return true;

            if (i >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is" + winner);
                return true;
            }
            return false;

    }

    public static void main(String[] args) {
        TestThread04 testThread04 = new TestThread04();
        TestThread04 testThread041 = new TestThread04();

        new Thread(testThread04, "兔子").start();
        new Thread(testThread041, "乌龟").start();
    }
}

/*
 结果：
 -------------------------------------------
 winner is 乌龟
 -------------------------------------------
 要点：winner只能有一个，所以要设置成static
    如果想让兔子睡觉，那么可以判断当前的线程是否是兔子，如果是就让他睡觉
 * */