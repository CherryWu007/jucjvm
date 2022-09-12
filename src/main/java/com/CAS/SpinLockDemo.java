package com.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.CAS
 * @ClassName : SpinLockDemo.java
 * @createTime : 2022/9/12 1:16
 * @Email :851185679@qq.com
 * @Description :
 *          实现一个自旋锁，复习CAS思想
 *          自旋锁好处：循环比较没有类似于wait的阻塞
 *
 *          思路：
 *          通过CAS操作完成自旋锁，A线程先进来调用Lock方法自己持有五秒中，B随后进来发现
 *          当前有线程持有锁，所以只能通过自旋等待，知道A释放过后抢到
 */

public class SpinLockDemo {
    //原子引用
    AtomicReference<Thread> atomicReference=new AtomicReference<>();
    public void lock(){
        Thread thread=new Thread();
        System.out.println(Thread.currentThread().getName()+"\t"+"---come in");
        //A线程进入并将自己写入
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }
    public void unlock(){
        Thread thread=Thread.currentThread();

        //释放锁并将数据改回null，方便其他线程占用
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t"+"---come out,unlock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo=new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.lock();
            try{
                //暂停几秒钟的线程
                TimeUnit.SECONDS.sleep(5);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                spinLockDemo.unlock();
            }
        },"A").start();
        //暂停500毫秒，保证线程A先于线程B启动
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //B线程
        new Thread(()->{
            spinLockDemo.lock();

            spinLockDemo.unlock();

        },"B").start();

    }
}
