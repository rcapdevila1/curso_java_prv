package com.privalia.collections;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Address address = new Address();
        List<Teacher> teacherList = new ArrayList<Teacher>();

        Teacher t1 = new Teacher();
        t1.setIdTeacher(1);
        t1.setName("Aqui esta la pasta");
        teacherList.add(t1);

        Teacher teacher2 = new Teacher();
        teacher2.setIdTeacher(2);
        teacher2.setName("jordi");
        teacherList.add(teacher2);

        Student student = new Student(address);
        student.setName("Ruben");
        student.setSurname("cap");
        student.setIdStudent(1);
        student.setAge(24);
        student.setTeacher(teacherList);



    }
}
