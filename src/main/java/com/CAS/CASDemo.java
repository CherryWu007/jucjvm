package com.CAS;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.CAS
 * @ClassName : CASDemo.java
 * @createTime : 2022/9/11 23:23
 * @Email :851185679@qq.com
 * @Description :
 */

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        //期望值是5，拿到的也是5，就将值更改为2022

        System.out.println(atomicInteger.compareAndSet(5,2022)+"\t"+atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
