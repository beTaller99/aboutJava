/**
 * @className: TestThread12_deadLock
 * @Description: 实现死锁
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/20 16:06
 */
public class TestThread12_deadLock {
    public static void main(String[] args) {
        DressUp dressUp = new DressUp("小明", 0);
        DressUp dressUp1 = new DressUp("小军", 1);
        dressUp.start();
        dressUp1.start();
    }
}

class Shirt {}

class Paints {}

class DressUp extends Thread{
    //保证资源只有一份：上衣只有一件，裤子只有一条
    static Shirt aShirt = new Shirt();
    static Paints paints = new Paints();

    //穿衣服的人的名字
    private String username;

    //一开始选择的资源
    int choice;  //0表示上衣  1表示裤子

    public DressUp(String username, int choice) {
        super(username);
        this.choice = choice;
        this.username = username;

    }

    @Override
    public void run() {
        try {
            toDressUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void toDressUp() throws InterruptedException {
        if (choice == 0) {
            //先把上衣锁拿到手
            synchronized (aShirt) {
                System.out.println(this.getName() + "拿到了上衣");

                //给另一个线程时间运行，也可以理解为花时间穿上衣服
                sleep(2000);

                synchronized (paints) {
                    System.out.println(getName() + "拿到了裤子");
                }
            }
        } else {
            synchronized (paints) {
                System.out.println(this.getName() + "拿到了裤子");

                sleep(1000);
                synchronized (aShirt) {
                    System.out.println(getName() + "拿到了上衣");
                }
            }
        }
    }
}
