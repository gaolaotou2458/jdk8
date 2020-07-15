package com.higer.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOnCloseDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");

        NullPointerException nullPointerException = new NullPointerException("my exception");

        try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aaaa");
                // throw new NullPointerException("first exception");
                throw nullPointerException;
            }).onClose(() -> {
                System.out.println("bbbb");
                //throw new ArithmeticException("second exception");
                throw nullPointerException;
            }).forEach(System.out::println);
        }
    }
}
