package com.sapient.week9.task3.controller;

import com.sapient.week9.task3.model.Student;
import com.sapient.week9.task3.model.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class StudentController {

    @Autowired
    StudentDAO service;

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(ModelMap model) {
        model.put("time", new Date());
        return "index";
    }

    @RequestMapping(value = "/result/student", method = RequestMethod.GET)
    public String result(@RequestParam("id") String id, ModelMap model) {
        model.put("time", new Date());

        try {
            Long _id = Long.parseLong(id);
            Student s = service.getStudent(_id);
            model.put("student", s);
        } catch (NullPointerException e) {
            model.put("errorMessage", "No student with such ID exists.");
            return "index";
        } catch (Exception e) {
            model.put("errorMessage", "Invalid ID.");
            return "index";
        }
        return "result";
    }
}
