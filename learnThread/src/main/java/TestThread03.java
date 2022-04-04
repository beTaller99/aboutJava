import static java.lang.Thread.sleep;

/**
 * @className: TestThread03
 * @Description: 创建多个线程操作同一个对象————买车票，会引发什么问题
 * @version: v1.８.0
 * @author: asher
 * @date: 2022/3/15 15:51
 */
public class TestThread03 implements Runnable{
    int tickets = 10;
    @Override
    public void run() {
        while(true) {
            if (tickets <= 0) break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
            System.out.println( Thread.currentThread().getName() + "拿到了第" + tickets-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread03 testThread03 = new TestThread03();
        TestThread03 testThread031 = new TestThread03();
        TestThread03 testThread032  = new TestThread03();

        new Thread(testThread03,"小明").start();
        new Thread(testThread031,"老师").start();
        new Thread(testThread032, "黄牛").start();
    }
}

/*
 * @return
 * -----------------------------------------------------------------
 *小明拿到了第7张票
老师拿到了第7张票
黄牛拿到了第7张票
* -------------------------------------------------------------------
* 对同一个票的结果重复了
*/
