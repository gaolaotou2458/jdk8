package com.higer.jdk8.myCollector;

import javax.swing.*;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class MySetColletor<T> implements Collector<T, Set<T>, Set<T>> {


    /**
     * 原始实现
     * T get();
     */
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier 被调用了");
        return HashSet<T>::new;
    }

    /**
     * 累加器
     *
     * @return
     */
    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator 被调用了");
        //考虑这里为什么不能HashSet<T>?  翻译：非静态方法不能再一个静态上下文中得到引用
        // 如果supplier 返回了TreeSet,这里就不一致冲突了
        return Set<T>::add;
    }

    /**
     * 用途：将并行流执行的多个结果合并起来
     *
     * @return
     */
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner 被调用了");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    /**
     * 完成器：多线程返回所有合并结果；单线程不用合并直接返回
     *
     * @return
     */
    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher 被调用了");
        //return t -> t;
        return Function.identity();//接收参数直接返回
        //return new UnsupportedOperationException();

    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics 被调用了");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, UNORDERED));
    }

    /*
    部分源码：
    return collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)
               ? (R) container
               : collector.finisher().apply(container);
     所以这里有IDENTITY_FINISH这个标识则不执行finisher()
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome", "hello");
        Set<String> set = list.stream().collect(new MySetColletor<>());
        System.out.println(set);
    }
}
