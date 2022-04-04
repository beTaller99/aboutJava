import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @className: TestReflection08
 * @Description: 通过反射获取泛型信息
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/28 21:43
 */
public class TestReflection08 {
    List<String> list;
    Map<Integer,Double> map;

    public static void main(String[] args) throws NoSuchFieldException {
        getGenericInfo();
    }

    static void getGenericInfo() throws NoSuchFieldException {
        Field declaredField = TestReflection08.class.getDeclaredField("list");
        Type genericType = declaredField.getGenericType();
        System.out.println(genericType);
        System.out.println("============开始获取List中的泛型信息");
        if (genericType instanceof ParameterizedType) {
            //获得真实类型
            Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }

        Field declaredField1 = TestReflection08.class.getDeclaredField("map");
        Type genericType1 = declaredField1.getGenericType();
        System.out.println(genericType1);
        if (genericType1 instanceof  ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericType1).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }

    }
}

/*
如何获取泛型信息：
 *1. 获取到泛型所在的method、field、在本例子中选择获取field
 2. 从获取的field中获取泛型genericType
 3. 判断genericType是否是parameteriedType
 4. 是，则从genericType中获取真实的参数类型actualParameterizedType
 5. 遍历获取到的actualParamitedType

*/