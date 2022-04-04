import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: TestGenerics002
 * @Description: 测试在泛型类中如何new出 T的实例
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/4/1 21:25
 */
public class TestGenerics002 {
    public static void main(String[] args) {

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Father02<T> {
    private T first;
    private T last;


}
