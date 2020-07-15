package com.higer.jdk8;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest2 {
    //compose
    @Test
    public void test1() {
        FunctionTest2 test = new FunctionTest2();
        System.out.println(test.compute(2, value -> value * 3, value -> value * value)); //12
        System.out.println(test.compute2(2, value -> value * 3, value -> value * value));//36
        System.out.println("=============");
        System.out.println(test.compute3(1, 2, (value1, value2) -> value1 + value2));
        System.out.println(test.compute3(1, 2, (value1, value2) -> value1 - value2));
        System.out.println(test.compute3(1, 2, (value1, value2) -> value1 * value2));
        System.out.println(test.compute3(1, 2, (value1, value2) -> value1 / value2));
        System.out.println("=============");
        System.out.println(test.compute4(2, 3, (value1, value2) -> value1 + value2, value -> value * value)); //25
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        //先执行funtion2 再执行当前的function1
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        //先执行当前的function1 再执行function2
        return function1.andThen(function2).apply(a);
    }

    /***
     *  biFunction:
     *  两个输入得到一个输出
     *
     */
    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    /*
     *
     */
    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,
                        Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
