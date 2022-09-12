package com.CAS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 老贼
 * @version : 1.0
 * @Project : jucjvm
 * @Package : com.CAS
 * @ClassName : Book.java
 * @createTime : 2022/9/12 16:56
 * @Email :851185679@qq.com
 * @Description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    //链式编程，流式计算
    private int id;
    private  String name;
    private double price;
    //常规写法
    public static void main(String[] args) {
        Book book=new Book();
        book.setId(11);
        book.setName("围城");
        book.setPrice(45L);

        //链式编程
        Book book1=new Book();
        book1.setId(12).setName("七月份的肖邦").setPrice(23L);

    }
}
