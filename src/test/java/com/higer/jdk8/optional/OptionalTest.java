package com.higer.jdk8.optional;


import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Test;

import java.util.Optional;

/**
 * if(null != person) {
 * Address address = new Address();
 * if(address != null){
 * ...
 * }
 * }
 */
public class OptionalTest {

    @Test
    public void test1() {
        //of里面不能为空，不然空指针
        Optional<String> optional = Optional.of("hello");
        //清空
        optional = Optional.empty();
        //if(optional.isPresent()){
        // System.out.println(optional.get());
        //}
        //推荐的方式
        optional.ifPresent(item -> System.out.println(item));
        System.out.println("-----------------");

        System.out.println(optional.orElse("world"));

        System.out.println("--------");
        System.out.println(optional.orElseGet(() -> "你好"));
    }
}
