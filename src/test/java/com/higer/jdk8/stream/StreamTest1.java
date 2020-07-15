package com.higer.jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {

    //流的创建方式1
    @Test
    public void test1() {
        Stream stream = Stream.of("hello", "world", "hello world");
        System.out.println(stream.count());

        String[] myArray = new String[]{"hello", "world", "hello world"};
        Stream stream2 = Stream.of(myArray);
        Stream stream3 = Arrays.stream(myArray);

        List<String> list = Arrays.asList(myArray);
        Stream stream4 = list.stream();


    }

    //流带来的简化
    @Test
    public void test2() {
        IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);

        System.out.println("====================");
        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("====================");
        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }


    //流进一步的使用
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        //reduce:终止操作，或者及早求值
        System.out.println(list.stream().map(item -> item * 2).reduce(0, Integer::sum));
        //
        System.out.println(list.stream().map(item -> item * 2).collect(Collectors.summingInt(item -> item)));

    }


}
