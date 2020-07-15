package com.higer.jdk8;

@FunctionalInterface
public interface MyInterface {

    void test();

    String toString();

    default void myString() {

    }
}

class Test2 {
    public void myTest2(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.myTest2(() -> System.out.println("mytest"));
        System.out.println("-------------------");

        MyInterface myInterface = () -> {
            System.out.println("hello");
        };

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}
