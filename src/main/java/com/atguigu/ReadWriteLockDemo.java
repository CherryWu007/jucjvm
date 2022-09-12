package com.atguigu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object>map=new HashMap<>();
    //添加读写锁
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public void put(String key,Object value){
        //给put操作加入写锁
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t写入数据"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t写入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            readWriteLock.writeLock().unlock();
        }


    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t读取成功");

            System.out.println(Thread.currentThread().getName()+"\t读取完成"+map.get(key));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            readWriteLock.readLock().unlock();
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
 * @ClassName : ReadWriteLockDemo.java
 * @createTime : 2022/9/8 14:44
 * @Email :851185679@qq.com
 * @Description :
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行，但是
 *
 * 如果有一个线程想去写共享资源类，就不应该再有其他线程可以对该资源进行读或写
 *
 * 读--能读能存
 *
 * 读--写不能共存
 *
 * 写--写不能共存
 */

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for(int i=1;i<=10;i++){
            final int finalI=i;
            new Thread(()->{
                myCache.put(finalI+"",finalI+"");
            },String.valueOf(i)).start();
        }
        for(int i=1;i<=10;i++){
            final int finalI=i;
            new Thread(()->{
                myCache.get(finalI+"");
            },String.valueOf(i)).start();
        }
    }
}
