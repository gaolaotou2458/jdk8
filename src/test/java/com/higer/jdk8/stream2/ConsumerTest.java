package com.higer.jdk8.stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTest {
    public void test(Consumer<Integer> consumer) {
        System.out.println("aaaaaa");
        consumer.accept(100);
    }

    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();
        //定义个表达式，可以赋值给Consumer<Intefer> IntConsumer

        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = i -> System.out.println(i);

        System.out.println(consumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        consumerTest.test(consumer); //面向对象方式传递参数
        consumerTest.test(consumer::accept); //传递行为，函数式方式
        consumerTest.test(intConsumer::accept);//函数式方式
    }
}
