package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private int flag=1;//1.A 2.B 3.C
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            //判断
            while (flag!=1){
                condition1.await();
            }
            //干活
            for (int i = 0; i <=5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知.更改标志位
            flag=2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            //判断
            while (flag!=2){
                condition1.await();
            }
            //干活
            for (int i = 0; i <=10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            flag=3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            //判断
            while (flag!=3){
                condition1.await();
            }
            //干活
            for (int i = 0; i <=15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            flag=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
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
 * @ClassName : ThreadOrderAccess.java
 * @createTime : 2022/9/8 19:10
 * @Email :851185679@qq.com
 * @Description :多线程之间按照顺序调用
 *
 *  多线程之间按顺序调用，实现A->B->C
 *  三个线程启动，要求如下：
 *
 *  AA打印5次，BB打印10次，CC打印15次
 *  接着
 *  AA打印5次，BB打印10次，CC打印15次
 *  ......来10轮
 *
 *  1 线程 操作  资源类
 *
 *  2 判断 干活 通知
 *
 *  3 防止虚假唤醒
 *
 *  4 多线程的标志位变更
 */

public class ThreadOrderAccess {

    public static void main(String[] args) {
        //线程操纵资源类
        ShareResource shareResource = new ShareResource();
        new Thread(()->{for (int i=0;i<10;i++) {
            shareResource.print5();
        }
        },"A").start();
        new Thread(()->{for (int i=0;i<10;i++) {
            shareResource.print10();
        }
        },"B").start();
        new Thread(()->{for (int i=0;i<10;i++) {
            shareResource.print15();
        }
        },"C").start();
    }
}
