package com.atguigu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : CyclicBarrierDemo.java
 * @createTime : 2022/9/11 22:28
 * @Email :851185679@qq.com
 * @Description :CyclicBarrier
 *              字面意思是可循环(Cyclic)使用的屏障，(Barrier).他要做的事情是
 *              让一组线程到达一个屏障(也可以叫同步点)时被阻塞，
 *              让一组线程达到屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活
 *              让线程进入屏障通过CyclicBarrier的await()方法。
 *
 *              集齐七颗龙珠才能召唤神龙
 */

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier= new CyclicBarrier(7,()->{
            System.out.println("----七颗龙珠，召唤神龙");
        });
        for(int i=1;i<=7;i++){
            int finalI = i;
            new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t收集到第"+ finalI +"\t颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
