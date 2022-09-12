package com.atguigu;
@FunctionalInterface
interface Foo
{
    public int add(int x,int y);
    default int sub(int x ,int y)
    {
        return x - y;
    }

    public static int div(int x ,int y)
    {
        return x/y;
    }
}

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.atguigu
 * @ClassName : LambdaDemo.java
 * @createTime : 2022/9/7 19:45
 * @Email :851185679@qq.com
 * @Description :lambda表达式练习
 * Lambda Express
 * 前提是函数式接口
 *
 * 1    拷贝小括号，写死右箭头，落地大括号
 * 2    @FunctionalInterface显示的定义一个函数式接口，假如不写，只有一个方法隐式的定义为函数式接口
 * 3    default:显示定义加实现，default方法可以有多个
 */

public class LambdaDemo
{
    public static void main(String[] args) {
        Foo foo=(x,y)->{System.out.println("-----------come in");return x+ y;};
        System.out.println(foo.add(2,3));

        Foo foo1=(x,y)->{System.out.println("=============come out");return x-y;};
    }
}
