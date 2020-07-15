package com.higer.jdk8.stream2;

public class LambdaTest {

    Runnable rl = () -> {
        System.out.println(this);
    };

    //new Runnable() 表示生成了实现了runnable接口的类的实例（匿名类）
    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();

        Thread t1 = new Thread(lambdaTest.rl);
        t1.start(); //com.higer.jdk8.stream2.LambdaTest@38ff6483
        System.out.println("-----------------");

        Thread t2 = new Thread(lambdaTest.r2);
        //这个匿名内部类
        t2.start(); //com.higer.jdk8.stream2.LambdaTest$1@3d6ddd95
    }
}
