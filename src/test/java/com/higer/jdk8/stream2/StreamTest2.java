package com.higer.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world", "111", "222", "333", "4444");
        //list.stream().parallel().forEach(System.out::println);

        Stream<String> stream = list.stream();
        System.out.println("1111");
        Stream<String> stream2 = stream.map(item -> item + "_abc");
        System.out.println(22222);
        stream2.forEach(System.out::println);

        list.stream().map(item -> item + "_abc").forEach(System.out::println);

    }
}
