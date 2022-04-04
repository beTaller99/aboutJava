package com.asher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: User
 * @Description: 这个类是为了帮助TestReflection05类来展示的
 * @version: openjdk-17.0.2
 * @author: asher
 * @date: 2022/3/27 17:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int age;
    private String name;
    private String sex;

    //定义这个方法是为了在TestReflection06中测试newInstance()方法能否使用private修饰的方法
    private void testNewInstan() {
        System.out.println("可以操作newInstance出来的对象的private方法");
    }


}
