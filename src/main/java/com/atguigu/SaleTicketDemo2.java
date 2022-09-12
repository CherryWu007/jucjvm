package com.atguigu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TrainTicket2{//资源类=Field+method，实例变量+实例方法
    private int number=50;
    Lock lock=new ReentrantLock(true);//独占锁+可重入锁+公平/默认非公平锁
    public void sale(){
        lock.lock();
                try {
                    if(number>0){
                        System.out.println(Thread.currentThread().getName()+"\t"+"卖出第: "+(number--)+"\t还剩下： "+number);
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
 * @ClassName : SaleTicketDemo2.java
 * @createTime : 2022/9/8 19:45
 * @Email :851185679@qq.com
 * @Description :使用lambda表达式写出老版卖票操作
 */

public class SaleTicketDemo2 {
    public static void main(String[] args) {
        TrainTicket2 trainTicket2 = new TrainTicket2();
        new Thread(()->{for (int i = 0; i < 51; i++) trainTicket2.sale();},"A").start();
        new Thread(() -> {for (int i = 0; i < 51; i++) trainTicket2.sale();},"B").start();
        new Thread(() -> {for (int i = 0; i < 51; i++) trainTicket2.sale();},"C").start();
    }
}
