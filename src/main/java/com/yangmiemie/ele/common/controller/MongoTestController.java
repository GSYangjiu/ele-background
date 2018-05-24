package com.yangmiemie.ele.common.controller;

import com.yangmiemie.ele.common.service.IStudentService;
import com.yangmiemie.ele.common.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 10:45
 * Description:
 */
@RequestMapping("/mongo")
@RestController
public class MongoTestController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/get/{id}")
    public Student getUser(@PathVariable int id) {
        return studentService.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        studentService.remove(id);
        return "delete sucess";
    }

    @GetMapping("/add")
    public String insert() {
        Student user = new Student(16, "" + 16, 16);
        studentService.insert(user);
        return "sucess";
    }

    @GetMapping("/insert")
    public String insertAll() {
        List<Student> list = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            list.add(new Student(i, "" + i, i));
        }
        studentService.insertAll(list);
        return "sucess";
    }

    @GetMapping("/find/all")
    public List<Student> find() {
        return studentService.findAll();
    }

    @PostMapping("/find/{start}")
    public List<Student> findByPage(@PathVariable int start, Student user) {
        Pageable pageable = new PageRequest(start, 2);
        return studentService.findByPage(user, pageable);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id) {
        Student user = new Student(id, "" + 1, 1);
        studentService.update(user);
        return "sucess";
    }

}