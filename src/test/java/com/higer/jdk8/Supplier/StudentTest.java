package com.higer.jdk8.Supplier;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * 提供者，不接收任何参数，返回一个结果
 */
public class StudentTest {
    public static void main(String[] args) {

        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());
        System.out.println("-----------------");

        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());
        System.out.println("-----------------");

        Supplier<Student> supplier3 = () -> new Student("222", 20);
        System.out.println(supplier3.get().getName());

    }

    //应用场景，工厂
    @Test
    public void test1() {

    }
}
