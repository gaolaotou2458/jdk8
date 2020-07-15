package com.higer.jdk8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {

    //
    @Test
    public void test1() {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        //String [] StringArr = stream.toArray(length -> new String[length]);
        //构造方法引用形式
        String[] StringArr = stream.toArray(String[]::new);
        Arrays.asList(StringArr).forEach(System.out::println);
    }


    @Test
    public void test2() {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");
        //默认返回ArrayList
        //List<String> list = stream.collect(Collectors.toList());
        /*
          R collect(
            Supplier<R> supplier,  //不接受参数返回值
            BiConsumer<R, ? super T> accumulator,  //接收两个参数
            BiConsumer<R, R> combiner); //合并器
       */

        //List<String> list = stream.collect(() -> new ArrayList<String>(),(theList,item) -> theList.add(item),
        //        (theList1,theList2)->theList1.addAll(theList2));

        //方法引用替代上面的写法
        //返回LinkedList就得重写
        List<String> list = stream.collect(LinkedList::new, LinkedList::add,
                LinkedList::addAll);
        System.out.println("========================");
        list.forEach(System.out::println);
    }
}
