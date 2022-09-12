package com.CAS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User3{
    private int id;
    private String name;
    private int age;
}
/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.CAS
 * @ClassName : User2.java
 * @createTime : 2022/9/12 17:03
 * @Email :851185679@qq.com
 * @Description :Q:按照给出的数据，找出同时满足以下条件的用户，也即以下条件全部能满足，
 *              偶数Id且年龄大于24，用户名转大写且用户名字母倒序
 *              只输出一个用户的名字
 *
 */

public class User2 {
    public static void main(String[] args) {
        User3 u1=new User3(11,"a",12);
        User3 u2=new User3(12,"b",13);
        User3 u3=new User3(13,"c",14);
        User3 u4=new User3(14,"d",15);
        User3 u5=new User3(15,"e",16);
        List<User3> list= Arrays.asList(u1,u2,u3,u4,u5);

        //Function函数型接口,有一个输入参数，有一个输出返回
        Function<String,Integer> function=s -> {return s.length();};
        System.out.println(function.apply("abs"));
        //Predicate,断定行接口，返回值为Boolean类型
        Predicate<String> predicate=s -> {return s.isEmpty();};
        System.out.println(predicate.test("张三"));
        //Consumer消费性接口返回类型void
        Consumer<String>consumer=s -> {
            System.out.println(s);
        };
        consumer.accept("爱咋咋地");
        //Supplier供给型接口,需要返回一个任意类型的数据
        Supplier<String>stringSupplier=()->{return "java0526";};
        System.out.println(stringSupplier.get());

        /*Predicate<String> predicate=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };*/
    }
}
interface MyInterface{
    public int myInt(int x);
    public String myString(String str);
    public Boolean isOK(String str);
}
