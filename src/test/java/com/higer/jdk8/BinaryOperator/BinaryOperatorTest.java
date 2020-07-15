package com.higer.jdk8.BinaryOperator;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;


/**
 * public interface BinaryOperator<T> extends BiFunction<T,T,T>
 * 参数和返回值类型一致
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest test = new BinaryOperatorTest();
        System.out.println(test.compute(1, 2, (item1, item2) -> item1 + item2));

        System.out.println(test.compute(1, 2, (item1, item2) -> item1 - item2));
        System.out.println("=============================");
        String min = test.testMinBy("hellow123", "world", (item1, item2) -> item1.compareTo(item2));
        System.out.println(min);
    }

    public int compute(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }


    public String testMinBy(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
