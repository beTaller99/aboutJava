/**
 * @className: TestThread06_1
 * @Description: 理解多线程中的静态代理
 * @version: v17.0.2
 * @author: asher
 * @date: 2022/3/17 21:34
 */
public class TestThread06_1 {
    /*
     * 静态代理是什么？ --- 就是将代理对象把目标对象的方法帮忙执行了，不需要目标对象自己去执行，需要目标对象和代理对象实现
     *                   同一个接口
     * 静态代理的好处？ --- 代理对象可以做很多目标对象做不了的事情，在当前文件中，目标对象只能说一句话，代理对象就可以
     *                   丰富目标对象能干的事情
     * 静态代理在多线程中的应用？ --- 我们可以将一个实现了Runnable接口的类直接放到new Thread()中，让Thread这个代理对象
     *                           帮助我们开启一个新的线程
     *                           new Thread(我们自己实现了Runnable接口的类对象)
    */

    public static void main(String[] args) {
        StaticProxy staticProxy = new ProxyObject(new Target());
        staticProxy.sayGood();
    }

}

interface StaticProxy {
    void sayGood();
}

class Target implements StaticProxy{

    @Override
    public void sayGood() {
        System.out.println("我是目标对象");
    }
}

class ProxyObject implements StaticProxy {

    private Target target;


    public ProxyObject(Target target) {
        this.target = target;
    }

    @Override
    public void sayGood() {
        System.out.println("开始代理目标对象");
        this.target.sayGood();
        System.out.println("代理结束");
    }
}
