package com.yangmiemie.ele.common.service.impl;

import com.yangmiemie.ele.common.dao.IStudentDAO;
import com.yangmiemie.ele.common.service.IStudentService;
import com.yangmiemie.ele.common.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 10:15
 * Description:
 */

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student getUser(Integer id) {
        return studentDAO.getUser(id);
    }

    @Override
    public void update(Student user) {
        studentDAO.update(user);
    }

    @Override
    public void insert(Student user) {
        studentDAO.insert(user);
    }

    @Override
    public void insertAll(List<Student> users) {
        studentDAO.insertAll(users);
    }

    @Override
    public void remove(Integer id) {
        studentDAO.remove(id);
    }

    @Override
    public List<Student> findByPage(Student user, Pageable pageable) {
        return studentDAO.findByPage(user, pageable);
    }
}
