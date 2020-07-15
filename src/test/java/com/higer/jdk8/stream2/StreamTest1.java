package com.higer.jdk8.stream2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {

    @Test
    public void test1() {
        Student student1 = new Student("张三", 80);
        Student student2 = new Student("李四", 90);
        Student student3 = new Student("王五", 100);
        Student student4 = new Student("赵六", 90);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        List<Student> students1 = students.stream().collect(Collectors.toList());
        students1.forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println("count:" + students.stream().collect(Collectors.counting()));
        System.out.println("count:" + students.stream().count());
    }
}
