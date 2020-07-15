package com.higer.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

public class MyTest {

    @Test
    public void test1() {
		/*
		TheInterface i1 = () -> {};
		System.out.println(i1.getClass().getInterfaces()[0]);

		TheInterface2 i2 = () -> {};
		System.out.println(i2.getClass().getInterfaces()[0]);

		new Thread(() -> {
			System.out.println("hellow world");
		}).start();
		*/
        List<String> list = Arrays.asList("hello", "world", "hello World");
        //list.forEach(item -> System.out.println(item.substring(0,1).toUpperCase() + item.substring(1,item.length())));

        //转化为大写并且生产新的集合
        List<String> list2 = new ArrayList<>();
        //list.forEach(item -> list2.add(item.toUpperCase()));
        //list2.forEach(item -> System.out.println(item));
        System.out.println("简化以上写法");


    }

    /**
     * strem 流
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList("hello", "world", "hello World");

        //给定一个值，返回另外一个值
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        System.out.println("相等下面的");
        list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));
        //构造方法引用
        //ArrayList::new;
    }

    @Test
    public void test3() {
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);

    }

    public static void main(String[] args) {

    }
}

@FunctionalInterface
interface TheInterface {

    void myMethod();
}

@FunctionalInterface
interface TheInterface2 {

    void myMethod2();
}