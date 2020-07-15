package com.higer.jdk8;

import org.junit.Test;

import java.util.function.Function;

public class FunctionTest {

    @Test
    public void test1() {
        FunctionTest test = new FunctionTest();
        /*

        System.out.println(test.compute(1, value -> {return 2*value;}));
        System.out.println(test.compute(2, value -> 5 + value));
        System.out.println(test.compute(3, value -> 5 + value));
        System.out.println("============================");

        */

        Function<Integer, Integer> function = value -> value + 1;
        System.out.println(test.compute(5, function));

        System.out.println(test.convert(5, value -> String.valueOf(value + " world")));

    }

    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    public int method1(int a) {
        return 2 + a;
    }

    public int method2(int a) {
        return 5 + a;
    }

    public int method3(int a) {
        return a * a;
    }
}
