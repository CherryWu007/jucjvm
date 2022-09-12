package com.atguigu;

import java.util.concurrent.*;

/**
 * @author 85118
 *
 * @create 2022-09-12 14:15
 * 线程池的拒绝策略
 */
public class MyThreadPoolDemo
{
    public static void main(String[] args)
    {
        // List list = new ArrayList();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());//CallerRunsPolicy：谁让过来的去找谁//DiscardPolicy：默默删除多余不能处理的不报错也不显示
        //DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加人队列中。尝试再次提交当前任务。


        try
        {
            for (int i = 1; i <=8; i++)
            {
                final int tmpI = i;
                threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 处理业务" + "\t 顾客: " + tmpI);
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }



    public static void initPool()
    {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();//一池1线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();//一池N线程

        try
        {
            for (int i = 1; i <=20; i++) {//模拟20个请求线程顾客，来办理业务，受理窗口目前有5个
                threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 处理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

}


