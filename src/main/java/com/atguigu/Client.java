package com.atguigu;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : Client.java
 * @createTime : 2022/9/7 19:58
 * @Email :851185679@qq.com
 * @Description :
 */

public class Client
{
    public static void main(String[] args) {
        Set set=new HashSet();
        int myHashCode=0;

        for (int i = 0; i < 120000; i++) {
            myHashCode=new Object().hashCode();

            if (set.contains(myHashCode)){
                System.out.println("hash冲突发生在第："+i+"\t 冲突值："+myHashCode);
            }
            set.add(myHashCode);


        }
        System.out.println(set.size());
    }
}
