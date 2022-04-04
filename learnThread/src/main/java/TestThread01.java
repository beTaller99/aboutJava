/**
 * @className: TestThread01
 * @Description: create a Thread by (@code extends Thread) extendsing Thread
 * @version: v17
 * @author: asher
 * @date: 2022/3/15 12:23
 */
public class TestThread01 extends Thread{
    public static void main(String[] args) {
        TestThread01 testThread01 = new TestThread01();
        testThread01.setName("testThread01");
        testThread01.start();
        for (int i = 0; i < 500; i++) {
            System.out.println("the value of i in main Thread is" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("the value of i in " + Thread.currentThread().getName() +  " Thread is" + i);
        }
    }
}
