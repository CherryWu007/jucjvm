package com.atguigu;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : SemaphoreDemo.java
 * @createTime : 2022/9/11 22:40
 * @Email :851185679@qq.com
 * @Description :信号灯，类似于抢车位
 */

public class SemaphoreDemo {
    public static void main(String[] args) {
        //模拟资源类，3个空车位
        Semaphore semaphore=new Semaphore(3);
        for(int i=1;i<=10;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢占到了车位");
                    //暂停一会线程模拟车位占用时间
                    try{
                        TimeUnit.SECONDS.sleep(5);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
