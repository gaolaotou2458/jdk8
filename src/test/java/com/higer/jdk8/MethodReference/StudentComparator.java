package com.higer.jdk8.MethodReference;

public class StudentComparator {

    public int compareStudentByScore(Student stu1, Student stu2) {

        return stu1.getScore() - stu2.getScore();
    }

    public int compareStudentByName(Student stu1, Student stu2) {

        return stu1.getName().compareTo(stu2.getName());
    }
}
