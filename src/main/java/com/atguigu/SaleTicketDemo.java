package com.atguigu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TrainTicket{
    private int number=50;
     Lock lock= new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"\t"+"卖出第："+(number--)+"\t还剩下："+number);
            }
        }finally {
            lock.unlock();
        }

    }
}
/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : SaleTicketDemo.java
 * @createTime : 2022/9/8 17:00
 * @Email :851185679@qq.com
 * @Description :买票练习，用线程池实现
 * * 三个售票员    卖出      50张票
 * * 如何编写企业级需要的工程化代码？ 多对1 多个线程操作同一个资源类
 * JUC口诀
 * OOP--面向对象编程
 *  1 你的需求是什么？空调制冷，点一下降低一个温度
 *
 *  2 你描述的需求我将它用一个方法搞定，告诉我，java一切皆对象
 *
 *  3 对象 = Field + method
 *
 *  4 方法  封装进入具体对象，这个对象就是被我们操作的资源类
 *
 *
 *  在高内聚低耦合前提下，线程  操作  资源类
 *      一言不合，先创建一个资源类
 */

public class SaleTicketDemo {
    public static void main(String[] args) {//主线程，一切程序的入口
        TrainTicket trainTicket=new TrainTicket();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            for (int i=0;i<51;i++){
                threadPool.execute(()->{trainTicket.sale();});


            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
