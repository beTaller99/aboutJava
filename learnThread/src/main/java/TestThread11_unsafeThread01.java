/**
 * @className: TestThread11_unsafeThread01
 * @Description: 通过买票程序展现线程不安全
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/19 20:42
 */
public class TestThread11_unsafeThread01 {
    public static void main(String[] args) {
        BuyTickets buyTickets = new BuyTickets();

        new Thread(buyTickets, "小明").start();
        new Thread(buyTickets, "小小明").start();
        new Thread(buyTickets, "小小小明").start();
    }
}

class BuyTickets implements Runnable{
    private int tickets = 10;

    private boolean flag = true;


    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    public void setFlag() {
        this.flag = false;
    }

    private synchronized void buy() {
        if (tickets <= 0) {
            setFlag();
            return;
        }
        try {
            if (Thread.currentThread().getName().equals("小明"))
            Thread.sleep(1000);

            if (Thread.currentThread().getName().equals("小小小明"))
                Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + "买到了票--》" + tickets--);
    }
}
