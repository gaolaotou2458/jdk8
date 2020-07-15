package com.higer.jdk8.myCollector;

import com.sun.javafx.collections.MappingChange;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collector.Characteristics.*;


/**
 * 1.输入：Set<String>
 * 2.输入：map<String>
 * <p>
 * 示例输入：["hello","world","hello world"]
 * 示例输出：【{hello,hello},{world,world},{hello world, hello world}】
 */
/*
 * @param <T> the type of input elements to the reduction operation
 * @param <A> the mutable accumulation type of the reduction operation (often
 *            hidden as an implementation detail)
 */
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {
    /*
     * <pre>{@code
     *     A a1 = supplier.get();
     *     accumulator.accept(a1, t1);
     *     accumulator.accept(a1, t2);
     *     R r1 = finisher.apply(a1);  // result without splitting
     *
     *     A a2 = supplier.get();
     *     accumulator.accept(a2, t1);
     *     A a3 = supplier.get();
     *     accumulator.accept(a3, t2);
     *     R r2 = finisher.apply(combiner.apply(a2, a3));  // result with splitting
     * } </pre>
     *
     * */
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier 被调用了");
        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator 被调用了");
        //return Set<T>::add;
        return (set, item) -> {
            System.out.println("accumulator:" + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner 被调用了");
        Map<T, T> map = new HashMap<T, T>();
        return (set1, set2) -> {
            System.out.println("set1" + set1);
            System.out.println("set2" + set2);
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher 被调用了");
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.stream().forEach(item -> map.put(item, item));
            return map;
        };

    }

    /**
     * IDENTITY_FINISH：
     * 设置这个属性后，根据collect 源码分析，将直接跳过finisher，并通过强制转换后返回返回类型
     *
     * @return
     * @Override
     * @SuppressWarnings("unchecked") public final <R, A> R collect(Collector<? super P_OUT, A, R> collector) {
     * A container;
     * .......
     * return collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)
     * ? (R) container
     * : collector.finisher().apply(container);
     * }
     * <p>
     * CONCURRENT:
     * 只有一个结果容器，就不跑combiner()
     */
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics 被调用了");
        //无序的用这个
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED));
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome", "hello", "a", "b", "c", "d", "e");
        Set<String> set = new HashSet<>();
        set.addAll(list);
        Map<String, String> map = set.parallelStream().collect(new MySetCollector2<>());
        System.out.println(map);
    }
}
