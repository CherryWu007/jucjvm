package com.CAS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;
@Data
@AllArgsConstructor
@NoArgsConstructor
class User{
    String username;
    int age;


}
/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.CAS
 * @ClassName : AtomicReferenceDemo.java
 * @createTime : 2022/9/12 1:05
 * @Email :851185679@qq.com
 * @Description :原子引用类AtomicReference
 */

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference=new AtomicReference<>();
        User z3=new User("z3",23);
        User li4=new User("li4",18);
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
    }
}
