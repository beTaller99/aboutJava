/**
 * @className: TestThread12_dealWithDeadLock
 * @Description: 在上一个程序的基础上解除死锁: 在拿到锁之后，使用完将锁释放就不会产生死锁
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/20 16:19
 */
public class TestThread12_dealWithDeadLock {
    public static void main(String[] args) {
        DealDressUp dealDressUp = new DealDressUp("HH", 0);
        DealDressUp dealDressUp1 = new DealDressUp("aa", 1);
        dealDressUp.start();
        dealDressUp1.start();
    }
}

class DealDressUp extends DressUp {
    public DealDressUp(String username, int choice) {
        super(username, choice);
    }

    @Override
    public void toDressUp() throws InterruptedException {
        if (choice == 0) {
            //先把上衣锁拿到手
            synchronized (aShirt) {
                System.out.println(this.getName() + "拿到了上衣");

                //给另一个线程时间运行，也可以理解为花时间穿上衣服
                sleep(2000);
            }
            //释放了上衣的锁
            synchronized (paints) {
                System.out.println(getName() + "拿到了裤子");
            }
        } else {
            synchronized (paints) {
                System.out.println(this.getName() + "拿到了裤子");

                sleep(1000);
            }
            //运行到这里就释放了裤子的锁
            synchronized (aShirt) {
                System.out.println(getName() + "拿到了上衣");
            }
        }
    }

}
