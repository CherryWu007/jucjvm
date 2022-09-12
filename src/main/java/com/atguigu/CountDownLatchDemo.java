package com.atguigu;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : CountDownLatchDemo.java
 * @createTime : 2022/9/8 20:12
 * @Email :851185679@qq.com
 * @Description :CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞
 *
 * 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)，
 * 当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(40);
        for(int i=1;i<=40;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"离开自习室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+"班长最后关门走人");
    }
}
