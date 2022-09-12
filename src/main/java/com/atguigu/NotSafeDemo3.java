package com.atguigu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : NotSafeDemo3.java
 * @createTime : 2022/9/11 15:52
 * @Email :851185679@qq.com
 * @Description :线程不安全展示
 */

public class NotSafeDemo3 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
