package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirCondition{
    private int flag=0;
    private Lock lock=new ReentrantLock();//ReentrantLock:可重入非公平的递归锁
    private Condition condition=lock.newCondition();
    public  void increment()throws Exception{//老版本
        lock.lock();
        try{
            //判断
            while (flag!=0){
                condition.await();
                //this.wait();
            }
            //加1操作
            flag++;
            System.out.println(Thread.currentThread().getName()+"\t"+flag);
            //通知
            condition.notifyAll();
            //this.notifyAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }


    }
    public  void decrement()throws Exception{
        //判断
        while (flag==0){
            condition.await();
        }
        //减1操作
        flag--;
        System.out.println(Thread.currentThread().getName()+"\t"+flag);
        //通知
        condition.notifyAll();
    }
    /*public synchronized void increment()throws Exception{     老版本
        //判断
        while (flag!=0){
            this.wait();
        }
        //加1操作
        flag++;
        System.out.println(Thread.currentThread().getName()+"\t"+flag);
        //通知
        this.notifyAll();
    }
    public synchronized void decrement()throws Exception{
        //判断
        while (flag==0){
            this.wait();
        }
        //减1操作
        flag--;
        System.out.println(Thread.currentThread().getName()+"\t"+flag);
        //通知
        this.notifyAll();
    }*/

}
/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : ProdConsumerDemo.java
 * @createTime : 2022/9/11 17:47
 * @Email :851185679@qq.com
 * @Description :题目：
 *                  现在两个线程，可以操作初始值为零的一个变量
 *                  实现一个线程对该变量加1，一个线程对该变量减1
 *                  实现交替，十轮，变量的初始值为零
 *
 *                  1、高内聚低耦合的前提下，线程操作资源类，
 *                  2、判断+干活+通知
 *                  3、为防止线程的虚假唤醒，只要有wait就需要用while判断
 *
 *                  总结：多线程编程套路+while判断+新版写法
 */

public class ProdConsumerDemo {
    public static void main(String[] args)throws Exception {
        AirCondition airCondition = new AirCondition();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
