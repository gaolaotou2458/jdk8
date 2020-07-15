package com.higer.jdk8.Predicate;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateTest2 test = new PredicateTest2();
        //奇数
        //List<Integer> collect = list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        //collect.forEach(i -> System.out.println(i));
        System.out.println("奇数");
        test.conditionFilter(list, item -> item % 2 != 0);
        //偶数
        System.out.println("偶数");
        test.conditionFilter(list, item -> item % 2 == 0);
        //>5
        System.out.println("==================");

        test.conditionFilter(list, item -> item > 5);

        test.conditionFilter(list, item -> true);
        //>3

    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(i -> {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        });
    }

    public void findAllEvents(List<Integer> list) {
        list.forEach(item -> {
            if (item % 2 == 0) System.out.println(item);
        });
    }

    // and方法测试
    public void conditionFilterAnd(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        list.forEach(i -> {
            if (predicate1.and(predicate2).test(i)) {
                System.out.println(i);
            }
        });
    }

    // and方法测试
    public void conditionFilterNegate(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        list.forEach(i -> {
            if (predicate1.negate().and(predicate2).test(i)) {
                System.out.println(i);
            }
        });
    }

    @Test
    public void testAnd() {
        PredicateTest2 test = new PredicateTest2();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        test.conditionFilterAnd(list, item -> item % 2 == 0, item2 -> item2 > 5);
        System.out.println("===================");
        test.conditionFilterNegate(list, item -> item % 2 == 0, item2 -> item2 > 5);
        System.out.println("=====================");
        System.out.println(Predicate.isEqual("test").test("test"));
    }


    public Predicate<String> isEqual(Object object) {
        return Predicate.isEqual(object);
    }
}
