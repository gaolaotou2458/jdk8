package com.higer.jdk8.MethodReference;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(item -> System.out.println(item));
        System.out.println("上面代码的语法糖");
        list.forEach(System.out::println);
    }

    //1.类名  + :: + 静态方法名。
    @Test
    public void test1() {
        Student student1 = new Student("张三", 10);
        Student student2 = new Student("李四", 90);
        Student student3 = new Student("王五", 50);
        Student student4 = new Student("赵六", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        //Collections.sort(students, (item1,item2) -> item1.getScore() - item2.getScore());
        //Collections.sort(students, Comparator.comparingInt(Student::getScore));
        //students.forEach(item -> System.out.println(item.getName() + "||" + item.getScore()));

        //传统的lambda 表达式方式
        //students.sort((studentParam1,studentParam2) -> Student.compareStudentByScore(studentParam1,studentParam2));
        //方法引用形式
        students.sort(Student::compareStudentByScore);
        students.forEach(item -> System.out.println(item.getScore()));
        System.out.println("============");
        students.sort(Student::compareStudentByName);
        students.forEach(item -> System.out.println(item.getName()));
    }

    // 2.引用名(对象名) + :: + 实例方法名
    @Test
    public void test2() {
        Student student1 = new Student("张三", 10);
        Student student2 = new Student("李四", 90);
        Student student3 = new Student("王五", 50);
        Student student4 = new Student("赵六", 40);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        StudentComparator studentComparator = new StudentComparator();
        //students.sort((studentParam1,studentParam2) -> studentComparator.compareStudentByName(studentParam1,studentParam2));

        students.sort(studentComparator::compareStudentByScore);
        students.forEach(item -> System.out.println(item.getScore()));

        students.sort(Student::compareStudentByName);
        students.forEach(item -> System.out.println(item.getName()));
    }

    //3.类名 ：： 实例方法名
    @Test
    public void test3() {
        Student student1 = new Student("张三", 10);
        Student student2 = new Student("李四", 90);
        Student student3 = new Student("王五", 50);
        Student student4 = new Student("赵六", 40);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        students.sort(Student::compareByScore);
        students.forEach(item -> System.out.println(item.getScore()));
        System.out.println("==================");
        students.sort(Student::compareByName);
        students.forEach(item -> System.out.println(item.getName()));
    }

    //3.类名 ：： 实例方法名(第一个参数对应this,后面的做为参数)
    @Test
    public void test4() {
        List<String> cities = Arrays.asList("qingdao", "chongqing", "tianjin", "beijing");
        /*
        Collections.sort(cities,(city1,city2) -> city1.compareToIgnoreCase(city2));
        cities.forEach(item -> System.out.println(item));
        */
        Collections.sort(cities, String::compareToIgnoreCase);
        cities.forEach(item -> System.out.println(item));
    }

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    //4：构造方法引用：类名：：new
    @Test
    public void test5() {
        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        System.out.println(methodReferenceDemo.getString(String::new));
        System.out.println("=====");
        System.out.println(methodReferenceDemo.getString2("hello", String::new));

    }
}
