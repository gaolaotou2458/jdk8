package com.higer.jdk8.optional;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalTest2 {

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

    public void test(Optional optional) {

    }
}
