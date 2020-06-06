package com.sapient.week9.task3.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class StudentDAO {

    private static HashMap<Long, Student> students;

    static {
        students = new HashMap<>();

        Result r1 = new Result();
        r1.marks = new HashMap<>();
        r1.marks.put("A", 97.0);
        r1.marks.put("B", 98.0);
        r1.marks.put("C", 97.0);
        r1.marks.put("D", 96.0);
        students.put(1L, new Student(1L, "Adam", r1));

        Result r2 = new Result();
        r2.marks = new HashMap<>();
        r2.marks.put("A", 95.0);
        r2.marks.put("B", 94.0);
        r2.marks.put("C", 97.0);
        r2.marks.put("D", 95.0);
        students.put(2L, new Student(2L, "Cole", r2));
    }

    public StudentDAO() {
    }

    public Student getStudent(Long id) {
        if (id == null) {
            return null;
        }
        return students.get(id);
    }
}
