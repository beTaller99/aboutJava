import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @className: TestGenerics001
 * @Description: 关于泛型类的继承
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/30 21:51
 */
public class TestGenerics001 {
    public static void main(String[] args) {
        //提出问题：子类继承泛型类，在不写构造方法的情况下，其构造方法会自动调用父类的构造方法吗
        Son01 son01 = new Son01(12,23);
        System.out.println(son01.getFirst());
    }
}

//测试思路：父类只允许传Integer数据,测试子类何时可以继承成功
@Data
@AllArgsConstructor
class Father01<T> {
    private T first;
    private T last;
}
/*
此段代码有误：研究发现，只有在继承的时候 父类的泛型是指定的具体引用类型，子类才能继承
class Son01 extends Father<T> {
    public Son01(T first, T last) {
        super(first, last);
    }
}
*/

//改进后的代码
class Son01 extends Father01<Integer> {
    public Son01(Integer first, Integer last) {
        super(first, last);
    }
}