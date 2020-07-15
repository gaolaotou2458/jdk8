package com.higer.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test1 {

    @Test
    public void test1(){
        List<String> list = Arrays.asList("hello","world","hello world");
        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return  length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //遍历
        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("=================");
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        });

        System.out.println("=================");
        //jdk8便利
        list.forEach(i -> System.out.println(i));

        //method reference
        list.forEach(System.out::println);
        //Runnable
    }
}
