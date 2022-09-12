package com.atguigu;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : NotSafeDemo.java
 * @createTime : 2022/9/7 20:54
 * @Email :851185679@qq.com
 * @Description :线程不安全练习
 *
 * java.util.ConcurrentModificationException:并发修改异常
 * 导致原因：next迭代器，数据不对，总数不匹配，modCount！=expectedModCount
 *
 *3 解决方案
 *  3.1 使用线程安全的类，Vector不用,版本太旧，虽然安全但是效率低
 *  3.2 Collections.synchronizedList不用
 *  3.3 CopyOnWriteArrayList,Yes ,读写分离+写时复制
 */

public class NotSafeDemo {
    /**
     * list类型各种实现类  CopyOnWriteArrayList<>()
     */
    private static void listNodeSafe(){
        List<String> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());  // new Vector<>();//new ArrayList<>();
        for(int i=1;i<=30;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    /**
     * set类型  CopyOnWriteArraySet<>()
     *
     * java.util.ConcurrentModificationException
     */
    private static void setNoteSafe() {
        Set<String >set= new CopyOnWriteArraySet<>();// Collections.synchronizedSet(new HashSet<>()); //new HashSet<>();
        for(int i=1;i<=30;i++){
        new Thread(()->{
            set.add(UUID.randomUUID().toString().substring(0,8));
            System.out.println(set);
        },String.valueOf(i)).start();
        }
    }

    public static void main(String[] args) {
        Map<String,String >map=new ConcurrentHashMap<>();//Collections.synchronizedMap(new HashMap<>());//new HashMap<>();
        for(int i=1;i<=10;i++){
        new Thread(()->{
            map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
            System.out.println(map);
        },String.valueOf(i)).start();
        }
    }
}
