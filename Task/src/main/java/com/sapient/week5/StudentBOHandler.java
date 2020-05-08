package com.sapient.week5;

import com.sapient.week5.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentBOHandler implements StudentBO {
    List<Student> students;

    public StudentBOHandler() {
        students = new ArrayList<>();
    }

    public void read() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter student as < id,name,city >: ");
            String[] ip = br.readLine().split(",");
            int id = Integer.parseInt(ip[0].trim());
            String name = ip[1].trim();
            String city = ip[2].trim().toLowerCase();
            students.add(new Student(id, name, city));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        students.forEach(System.out::println);
    }

    public void display(String city) {
        students.stream().filter(s -> s.getCity().equals(city.toLowerCase()))
                .forEach(System.out::println);
    }

    public void displayNameWise() {
        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    public void displayCityWise() {
        students.stream()
                .sorted(Comparator.comparing(Student::getCity))
                .forEach(System.out::println);
    }

    public void display(int id) throws Exception {
        Optional<Student> student =
                students.stream()
                        .filter(s -> s.getId() == id)
                        .findFirst();
        if (student.isPresent()) {
            System.out.println(student.get());
        } else {
            throw new Exception("Student id does not exist.");
        }
    }
}
