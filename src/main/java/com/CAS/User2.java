package com.CAS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

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
    }
}
