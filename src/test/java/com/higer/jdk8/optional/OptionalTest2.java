package com.higer.jdk8.optional;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalTest2 {

    private static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("张三");

        Employee employee2 = new Employee();
        employee2.setName("李四");

        Company company = new Company();
        company.setName("公司");

        List<Employee> employees = Arrays.asList(employee, employee2);
        company.setEmployees(employees);

        List<Employee> list = company.getEmployees();
        /* 传统
        if(list != null) {
            return list;
        } else {
            return new ArrayList<Employee>();
        }
        */
        //1 .构造容器
        Optional<Company> optional = Optional.ofNullable(company);
        // jdk8实现上述功能
        //有数据直接返回，没有直接返回空集合
        // map 映射功能
        System.out.println(optional.map(theCompany -> theCompany.getEmployees())
                .orElse(Collections.emptyList()));
    }

    private static User anoymos(){
        return new User();
    }
    //有意义的用法
    @Test
    public void test(Optional optional) {
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        //存在即返回，空则提供默认值
        optionalUser.orElse(new User());
        //存在即返回，空则由函数去产生
        optionalUser.orElseGet(() -> anoymos());
        //村在即返回，否则抛出异常
        optionalUser.orElseThrow(RuntimeException::new);
        //存在才去做相应的事情
        optionalUser.ifPresent(u -> System.out.println(u.getName()));

        // map可以对 Optional 中的对象执行某种操作，且会返回一个Optional 对象
        optionalUser.map(user1 -> user1.getName()).orElse("anymos");
    }
}
