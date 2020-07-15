package com.higer.jdk8.stream;


import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流的短路和并发流.
 */
public class StreamTest5 {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {

            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序");
        long startTime = System.nanoTime();
        //串行流 一个线程
        //list.stream().sorted().count();
        //并行流 利用计算机底层多核心
        list.parallelStream().sorted().count();
        long endTime = System.nanoTime();
        //纳秒转为毫秒
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(millis);


    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        //list.stream().mapToInt(item -> item.length()).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
        //list.stream().filter(item -> item.length() == 5).findFirst().ifPresent(System.out::println);
        System.out.println("============");
        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length >= 5).findFirst().ifPresent(System.out::println);
    }


    //flatMap使用
    //=============================================================
    @Test
    public void test3() {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        //List<String[]> result = list.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList());
        //result.forEach(item -> Arrays.asList(item).forEach(System.out::println));

        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().
                collect(Collectors.toList()).forEach(System.out::println);
    }

    //双重循环拼接
    @Test
    public void test4() {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("张三", "李四", "王五", "赵六");
        List<String> list3 = list1.stream().flatMap(item1 -> list2.stream().map(item2 -> item1 + " :" + item2)).collect(Collectors.toList());
        list3.forEach(System.out::println);
    }


    //分组:name
    @Test
    public void testGroup() {
        Student student1 = new Student("张三", 100, 20);
        Student student2 = new Student("李四", 90, 20);
        Student student3 = new Student("王五", 90, 30);
        Student student4 = new Student("张三", 80, 40);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("========================");

        Map<Integer, List<Student>> map1 = students.stream().collect(Collectors.groupingBy(Student::getScore));
        map1.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        System.out.println("========================");
        Map<String, Long> map2 = students.stream().
                collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        map2.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        System.out.println("========================");
        Map<String, Double> map3 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        map3.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }


    //分区
    @Test
    public void testPartitionBy() {
        Student student1 = new Student("张三", 100, 20);
        Student student2 = new Student("李四", 90, 20);
        Student student3 = new Student("王五", 90, 30);
        Student student4 = new Student("张三", 80, 40);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        Map<Boolean, List<Student>> map = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        System.out.println("================");
        List<Student> students1 = map.get(true);
        students1.forEach(System.out::println);


    }
}
