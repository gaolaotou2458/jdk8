package com.higer.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest3 {

    @Test
    public void test1() {
        /*
        Stream<String> stream = Stream.of("hello","world","helloworld");
        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
        list.forEach(System.out::println);
        */

        /*
        Stream<String> stream = Stream.of("hello","world","helloworld");
        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set.getClass());
        set.forEach(System.out::println);
        */
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        String str = stream.collect(Collectors.joining("-"));
        System.out.println(str);
    }

    @Test
    public void test2() {
        //需求：转化为大写输出
        List<String> list = Arrays.asList("hello", "world", "hello world", "test");
        //方式一
        list.forEach(item -> System.out.println(item.toUpperCase()));
        System.out.println("====");
        //方式二
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        list2.stream().map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("------------");

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        stream.flatMap(theList -> theList.stream().map(item -> item * item))
                .forEach(System.out::println);
    }

    @Test
    public void test7() {
        //不加foreach 不输出，不遇到终止操作，中间操作都不执行，因为流是一个惰性求值2
        List<String> list = Arrays.asList("hello", "world", "hello world", "test");
        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1, item.length());
            System.out.println("test");
            return result;
        }).forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);
        //串行流，不断应用第二个参数执行函数，执行6次
        Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);
    }

    //找出流中大于二的元素，然后将每个元素 * 2，然后忽略流中前两个元素，然后再取流中前两个元素，最后求出元素的总和
    @Test
    public void test4() {
        //1,3,5,7,9,11
        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);
        //int sum = stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum();
        //System.out.println("sum" + sum);

        //stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);
        IntSummaryStatistics intSummaryStatistics = stream.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.toString());

    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("hello", "world", "helloworld", "test");
        list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1, item.length()))
                .forEach(System.out::println);
    }

    @Test
    public void test6() {
        //IntStream.iterate(0,i ->(i+1)%2).distinct().limit(6).forEach(System.out::println);
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }
}
