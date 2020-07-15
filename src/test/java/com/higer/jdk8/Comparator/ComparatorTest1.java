package com.higer.jdk8.Comparator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest1 {

    @Test
    public void test1() {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welocome");
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println("=============");
        Collections.sort(list, (item1, item2) -> item1.length() - item2.length());
        System.out.println(list);
        //反转
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("==========");
        //串行排序
        Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        System.out.println(list);
        //不适用方法引用
        Collections.sort(list, Comparator.comparingInt(item -> item.toString().length()).reversed());
        System.out.println(list);

        Collections.sort(list, Comparator.comparingInt((Object item) -> 1).reversed());
        System.out.println(list);
        System.out.println("------------------");
        //和调用 Collections.sort 效果一样
        list.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(list);
        //先排第一个，第一个不能确定顺序才运行thenComparing
        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);
        System.out.println("===============");

    }

}
