package com.higer.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream()
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person1 = new Person("张三", 20);
        Person person2 = new Person("李四", 40);
        Person person3 = new Person("王五", 60);

        List<Person> persons = Arrays.asList(person1, person2, person3);
        PersonTest personTest = new PersonTest();
        List<Person> list1 = personTest.getPersonsByUsername("张三", persons);
        list1.forEach(p -> System.out.println(p.toString()));

        System.out.println("BiFunction=========================");
        List<Person> list2 = personTest.getPersonsByAge(20, persons);
        list2.forEach(p -> System.out.println(p.toString()));

        System.out.println("============动态传入biFunction操作=================");
        //通过传递函数的行为
        List<Person> list3 = personTest.getPersonByAge2(20, persons, (age, personList) -> {
            return persons.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        });
        list3.forEach(p -> System.out.println(p.toString()));

    }

    public List<Person> getPersonsByUsername(String username, List<Person> persons) {
        //过滤查找然后收集
        return persons.stream().filter(p -> p.getUsername().equals(username)).collect(Collectors.toList());
    }

    //通过Bifunction 接收2个参数，返回一个
    public List<Person> getPersonsByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (
                ageOfPerson, personList) -> personList.stream().filter(p -> p.getAge() > ageOfPerson).collect(Collectors.toList()
        );
        return biFunction.apply(age, persons);
    }

    public List<Person> getPersonByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }
}
