package com.higer.jdk8.Supplier;

import org.junit.Test;

import java.util.function.Supplier;

public class SupplierTest {
    //不接受参数同时返回一个结果
    //
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello world";
        System.out.println(supplier.get());


    }


}
